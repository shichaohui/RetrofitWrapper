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

package com.sch.retrofit.wrapper.api

import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*

/**
 * Created by StoneHui on 2017/7/18.
 * <p>
 * Api 服务。
 */
interface ApiService {

    /**
     * 发起 post 请求
     *
     * @param url 请求地址
     * @param rawParams raw 参数
     * @param urlParams url 参数
     * @param headerMap 请求头
     */
    @POST
    fun postRaw(
            @Url url: String,
            @Body rawParams: RequestBody,
            @QueryMap urlParams: Map<String, @JvmSuppressWildcards Any> = mapOf(),
            @HeaderMap headerMap: Map<String, String> = mapOf()
    ): Observable<ResponseBody>

    /**
     * 发起 post 请求
     *
     * @param url 请求地址
     * @param formParams form 参数
     * @param urlParams url 参数
     * @param headerMap 请求头
     */
    @FormUrlEncoded
    @POST
    fun postForm(
            @Url url: String,
            @FieldMap formParams: Map<String, @JvmSuppressWildcards Any>,
            @QueryMap urlParams: Map<String, @JvmSuppressWildcards Any> = mapOf(),
            @HeaderMap headerMap: Map<String, String> = mapOf()
    ): Observable<ResponseBody>

    /**
     * 发起 post 请求
     *
     * @param url 请求地址
     * @param urlParams url 参数
     * @param partMap multipart 数据
     * @param headerMap 请求头
     */
    @Multipart
    @POST
    fun postMultipart(
            @Url url: String,
            @PartMap partMap: Map<String, @JvmSuppressWildcards RequestBody>,
            @QueryMap urlParams: Map<String, @JvmSuppressWildcards Any> = mapOf(),
            @HeaderMap headerMap: Map<String, String> = mapOf()
    ): Observable<ResponseBody>

    /**
     * 发起 post 请求
     *
     * @param url 请求地址
     * @param urlParams url 参数
     * @param headerMap 请求头
     */
    @POST
    fun post(
            @Url url: String,
            @QueryMap urlParams: Map<String, @JvmSuppressWildcards Any> = mapOf(),
            @HeaderMap headerMap: Map<String, String> = mapOf()
    ): Observable<ResponseBody>

    /**
     * 发起 get 请求
     *
     * @param url 请求地址
     * @param urlParams url 参数
     * @param headerMap 请求头
     */
    @GET
    fun get(
            @Url url: String,
            @QueryMap urlParams: Map<String, @JvmSuppressWildcards Any> = mapOf(),
            @HeaderMap headerMap: Map<String, String> = mapOf()
    ): Observable<ResponseBody>

    /**
     * 下载
     *
     * @param url 下载地址
     */
    @Streaming
    @GET
    fun download(@Url url: String): Observable<ResponseBody>

}