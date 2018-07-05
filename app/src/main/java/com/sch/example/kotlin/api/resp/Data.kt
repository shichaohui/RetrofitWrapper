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

package com.sch.example.kotlin.api.resp

/**
 * Created by StoneHui on 2018/7/5.
 *
 * 返回数据。
 */
class Data(var status: Boolean, var total: Int, var tngou: List<Gallery>) {

    override fun toString(): String {
        return "Data{" +
                "status=" + status +
                ", total=" + total +
                ", tngou=" + tngou +
                '}'.toString()
    }

    class Gallery(var id: Int, var galleryclass: Int, var title: String, var img: String,
                           var count: Int, var rcount: Int, var fcount: Int, var size: Int) {

        override fun toString(): String {
            return "Gallery{" +
                    "id=" + id +
                    ", galleryclass=" + galleryclass +
                    ", title='" + title + '\''.toString() +
                    ", img='" + img + '\''.toString() +
                    ", count=" + count +
                    ", rcount=" + rcount +
                    ", fcount=" + fcount +
                    ", size=" + size +
                    '}'.toString()
        }
    }

}
