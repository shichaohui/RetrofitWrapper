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

package com.sch.retrofit.wrapper.request

/**
 * Created by StoneHui on 2017/7/25.
 * <p>
 * 用来支持 raw 参数
 */
interface SupportRawParams {

    /**
     * 返回 raw 参数（ Map<参数名, 参数值> ）
     */
    fun getRawParams(): Map<String, Any>

}