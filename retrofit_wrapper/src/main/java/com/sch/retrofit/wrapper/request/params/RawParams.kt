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

package com.sch.retrofit.wrapper.request.params

import com.sch.retrofit.wrapper.RetrofitWrapper
import com.sch.retrofit.wrapper.request.SupportRawParams

/**
 * Created by StoneHui on 2017/7/25.
 * <p>
 * raw 参数，同时支持 url 参数。
 *
 * @param url 接口地址，可以是完整的【协议+域名+路径】，也可以省略【协议+域名】，省略后则自动拼接 [RetrofitWrapper] 中配置的 baseUrl 。
 * @param T 接口返回数据的类型
 */
abstract class RawParams<T>(url: String) : UrlParams<T>(url), SupportRawParams {

    @Transient
    private val rawParams: MutableMap<String, Any> = mutableMapOf()

    final override fun getRawParams(): MutableMap<String, Any> = rawParams

    /**
     * 插入参数
     *
     * @param key 键
     * @param key 值
     */
    fun putRawParams(key: String, value: Any) {
        rawParams[key] = value
    }

    /**
     * 插入参数
     *
     * @param params 参数，参数的格式为 Pair<参数名, 参数值>
     */
    fun putRawParams(vararg params: Pair<String, Any>) {
        rawParams.putAll(params)
    }

    /**
     * 插入参数
     *
     * @param params 参数，参数的格式为 Map<参数名, 参数值>
     */
    fun putRawParams(params: Map<String, Any>) {
        rawParams.putAll(params)
    }

}