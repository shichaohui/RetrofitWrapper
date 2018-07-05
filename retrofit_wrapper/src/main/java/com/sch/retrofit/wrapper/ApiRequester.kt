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

import com.google.gson.Gson
import com.sch.retrofit.wrapper.api.ApiService
import com.sch.retrofit.wrapper.request.*
import com.sch.retrofit.wrapper.request.params.BaseRequestParams
import com.sch.retrofit.wrapper.request.params.MultipartParams
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Retrofit

/**
 * Created by StoneHui on 2018/7/5.
 * <p>
 * API 请求封装。
 */
object ApiRequester {

    private var apiService: ApiService? = null

    private val gson = Gson()

    internal fun createApiService(retrofit: Retrofit) {
        apiService = retrofit.create(ApiService::class.java)!!
    }

    /**
     * 发起 Get 请求
     *
     * @param requestParams 请求参数
     * @param T 请求结果的类型
     * @return 请求结果
     */
    @JvmStatic
    fun <T> get(requestParams: BaseRequestParams<T>): Observable<T> {

        val headers = if (requestParams is SupportHeaders) requestParams.getHeaders() else mapOf()
        val urlParams = if (requestParams is SupportUrlParams) requestParams.getUrlParams() else mapOf()

        // 传递 form 参数和 url 参数
        return apiService!!.get(requestParams.url, urlParams, headers)
                .map { gson.fromJson<T>(it.string(), requestParams.responseType) }
    }

    /**
     * 发起 Post 请求
     *
     * @param requestParams 请求参数
     * @param T 请求结果的类型
     * @return 请求结果
     */
    @JvmStatic
    fun <T> post(requestParams: BaseRequestParams<T>): Observable<T> {

        val headers = if (requestParams is SupportHeaders) requestParams.getHeaders() else mapOf()
        val urlParams = if (requestParams is SupportUrlParams) requestParams.getUrlParams() else mapOf()

        return when (requestParams) {
            is SupportFormParams -> {
                // 传递 form 参数、 url 参数
                apiService!!.postForm(requestParams.url, requestParams.getFormParams(), urlParams, headers)
            }
            is SupportRawParams -> {
                // 处理 raw 参数
                val params = RetrofitHelper.createRequestBody(gson.toJson(requestParams.getRawParams()))
                // 传递 raw 参数 和 url 参数
                apiService!!.postRaw(requestParams.url, params, urlParams, headers)
            }
            is SupportMultipartParams -> {
                // 传递 url 参数、multipart 参数
                apiService!!.postMultipart(requestParams.url, requestParams.getMultipartParams(), urlParams, headers)
            }
            else -> {
                // 传递 url 参数、或者无参数
                apiService!!.post(requestParams.url, urlParams, headerMap = headers)
            }
        }.map { gson.fromJson<T>(it.string(), requestParams.responseType) }
    }

    /**
     * 上传
     *
     * @param uploadParams 参数
     */
    @JvmStatic
    fun <T> upload(uploadParams: MultipartParams<T>): Observable<T> {
        val headers = if (uploadParams is SupportHeaders) uploadParams.getHeaders() else mapOf()
        // 传递 url 参数、multipart 参数
        return apiService!!.postMultipart(uploadParams.url, uploadParams.getMultipartParams(), uploadParams.getUrlParams(), headers)
                .map { gson.fromJson<T>(it.string(), uploadParams.responseType) }
    }

    /**
     * 下载
     *
     * @param url 下载地址
     */
    @JvmStatic
    fun download(url: String): Observable<ResponseBody> {
        return apiService!!.download(url)
    }

}