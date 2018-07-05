/*
 * Copyright (c) 2015-2018 Shi ChaoHui
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sch.retrofit.wrapper

import com.sch.retrofit.wrapper.convert.GsonConverterFactory
import io.reactivex.schedulers.Schedulers
import okhttp3.Dispatcher
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File

/**
 * Created by StoneHui on 2017/7/18.
 *
 * Retrofit 辅助工具
 */
object RetrofitHelper {

    /**
     * 创建 Retrofit 对象
     *
     * @param baseUrl 协议+域名
     * @param logLevel log 的输出等级
     */
    fun createRetrofit(baseUrl: String, logLevel: Level = Level.NONE): Retrofit {

        val dispatcher = Dispatcher()
        dispatcher.maxRequestsPerHost = 20

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = logLevel

        val client = OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

        return retrofit
    }

    /**
     * 创建[RequestBody]
     *
     * @param text 文本
     */
    @JvmStatic
    fun createRequestBody(text: String): RequestBody {
        return RequestBody.create(MediaType.parse("text/plain"), text)
    }

    /**
     * 创建[RequestBody]
     *
     * @param file 文件
     */
    @JvmStatic
    fun createRequestBody(file: File): RequestBody {
        return RequestBody.create(MediaType.parse("multipart/form-data"), file)
    }

}