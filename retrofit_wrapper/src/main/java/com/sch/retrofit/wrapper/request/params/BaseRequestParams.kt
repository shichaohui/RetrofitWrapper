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

import com.sch.retrofit.wrapper.request.SupportFormParams
import com.sch.retrofit.wrapper.request.SupportHeaders
import com.sch.retrofit.wrapper.request.SupportMultipartParams
import com.sch.retrofit.wrapper.request.SupportRawParams
import com.sch.retrofit.wrapper.request.SupportUrlParams
import com.sch.retrofit.wrapper.RetrofitWrapper
import java.lang.reflect.Type

/**
 * Created by StoneHui on 2017/7/18.
 * <p>
 * 发起请求的数据基类。
 * <p>
 * 如果要添加请求头（header），让子类实现 [SupportHeaders] 接口并返回相应数据。
 * <p>
 * 如果要传递 url 参数，让子类实现 [SupportUrlParams] 接口并返回相应数据, 或者使用 [UrlParams]。
 * <p>
 * 如果要传递 raw（json 格式）参数，让子类实现 [SupportRawParams] 接口并添加要传递的参数作为属性, 或者使用 [RawParams]。
 * <p>
 * 如果要传递 form 参数，让子类实现 [SupportFormParams] 接口并返回相应数据, 或者使用 [FormParams]。
 * <p>
 * 如果要传递 multipart 参数，让子类实现 [SupportMultipartParams] 接口并返回相应数据。
 *
 * @param url 接口地址，可以是完整的【协议+域名+路径】，也可以省略【协议+域名】，省略后则自动拼接 [RetrofitWrapper] 中配置的 baseUrl 。
 * @param T 接口返回数据的类型
 */
abstract class BaseRequestParams<T>(@Transient internal val url: String) {

    abstract val responseType: Type

    init {
        if (url.startsWith("/")) {
            throw RuntimeException("接口地址【$url】不能以 / 开头")
        }
    }

}