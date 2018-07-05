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

package com.sch.retrofit.wrapper.convert.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sch.retrofit.wrapper.convert.serializer.*

/**
 * Created by StoneHui on 2017/7/24.
 * <p>
 * Gson 扩展。
 */
object GsonHelper {

    /**
     * 创建 Gson 对象。
     */
    fun create(): Gson {
        val booleanSerializer = BooleanSerializer()
        val stringSerializer = StringSerializer()
        val integerSerializer = IntegerSerializer()
        val longSerializer = LongSerializer()
        val floatSerializer = FloatSerializer()
        val doubleSerializer = DoubleSerializer()

        return GsonBuilder()
                .registerTypeAdapter(Boolean::class.java, booleanSerializer)
                .registerTypeAdapter(Boolean::class.javaPrimitiveType, booleanSerializer)
                .registerTypeAdapter(String::class.java, stringSerializer)
                .registerTypeAdapter(Int::class.java, integerSerializer)
                .registerTypeAdapter(Int::class.javaPrimitiveType, integerSerializer)
                .registerTypeAdapter(Long::class.java, longSerializer)
                .registerTypeAdapter(Long::class.javaPrimitiveType, longSerializer)
                .registerTypeAdapter(Float::class.java, floatSerializer)
                .registerTypeAdapter(Float::class.javaPrimitiveType, floatSerializer)
                .registerTypeAdapter(Double::class.java, doubleSerializer)
                .registerTypeAdapter(Double::class.javaPrimitiveType, doubleSerializer)
                .create()

    }

}