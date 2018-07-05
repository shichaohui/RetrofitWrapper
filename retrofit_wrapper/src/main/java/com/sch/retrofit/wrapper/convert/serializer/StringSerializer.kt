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

package com.sch.retrofit.wrapper.convert.serializer

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter

import java.io.IOException

/**
 * Create by StoneHui on 17/1/10.
 *
 * String 类型的序列化工具。
 */
class StringSerializer : TypeAdapter<String>() {

    @Throws(IOException::class)
    override fun write(writer: JsonWriter, value: String) {
        writer.value(value)
    }

    @Throws(IOException::class)
    override fun read(reader: JsonReader): String {
        val peek = reader.peek()
        if (peek == JsonToken.NULL) {
            reader.nextNull()
            return ""
        }
        /* coerce booleans to strings for backwards compatibility */
        if (peek == JsonToken.BOOLEAN) {
            return java.lang.Boolean.toString(reader.nextBoolean())
        }
        return reader.nextString()
    }

}