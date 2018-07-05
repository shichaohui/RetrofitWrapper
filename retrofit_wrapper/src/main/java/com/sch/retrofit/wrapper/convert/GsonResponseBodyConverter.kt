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

package com.sch.retrofit.wrapper.convert

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.MalformedJsonException

import java.io.IOException

import okhttp3.ResponseBody
import retrofit2.Converter

/**
 * Created by StoneHui on 16/5/12.
 */
class GsonResponseBodyConverter<T>(private val gson: Gson, private val adapter: TypeAdapter<T>) : Converter<ResponseBody, T> {

    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T? {
        val jsonReader = gson.newJsonReader(value.charStream())
        try {
            return adapter.read(jsonReader)
        } catch (exception: MalformedJsonException) {
            exception.printStackTrace()
            return null
        } finally {
            value.close()
        }
    }

}