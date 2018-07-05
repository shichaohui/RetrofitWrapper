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

import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit

/**
 * Created by StoneHui on 2017/7/18.
 * <p>
 * Retrofit 封装
 */
object RetrofitWrapper {

    /**
     * 初始化 RetrofitWrapper 库
     *
     * @param baseUrl 协议+域名，必须以 / 结尾。
     * @param logLevel log 的输出等级。
     */
    @JvmOverloads
    @JvmStatic
    fun init(baseUrl: String, logLevel: Level = Level.NONE) {
        val retrofit = RetrofitHelper.createRetrofit(
                if (baseUrl.endsWith("/")) baseUrl else "$baseUrl/",
                logLevel)
        ApiRequester.createApiService(retrofit)
    }

    /**
     * 初始化 RetrofitWrapper 库
     *
     * @param retrofit [Retrofit]对象。
     */
    @JvmStatic
    fun init(retrofit: Retrofit) {
        ApiRequester.createApiService(retrofit)
    }

}