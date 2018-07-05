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

package com.sch.example.kotlin.api.req

import com.sch.example.kotlin.api.resp.Data
import com.sch.retrofit.wrapper.request.params.UrlParams

import java.lang.reflect.Type

/**
 * Created by StoneHui on 2018/7/5.
 *
 * Url 传参的请求。
 */
class GalleryClassByUrl(id: Int, rows: Int, page: Int) : UrlParams<Data>("tnfs/api/list") {

    override val responseType: Type = Data::class.java

    init {

        putUrlParams("id", id)
        putUrlParams("rows", rows)
        putUrlParams("page", page)
    }

}