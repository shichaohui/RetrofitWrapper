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

package com.sch.example.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sch.example.kotlin.api.req.GalleryClassByForm
import com.sch.example.kotlin.api.req.GalleryClassByRaw
import com.sch.example.kotlin.api.req.GalleryClassByUrl
import com.sch.retrofit.wrapper.ApiRequester
import com.sch.retrofit.wrapper.RetrofitWrapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import stonehui.retrofitwrapper.R

/**
 * Created by StoneHui on 2018/7/5.
 */
class MainActivity : AppCompatActivity() {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitWrapper.init("http://www.tngou.net/")

        compositeDisposable.add(ApiRequester.get(GalleryClassByUrl(6, 5, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data ->
                    println("---------- url -----------")
                    println(data)
                    println("---------- -- -----------")
                })

        compositeDisposable.add(ApiRequester.post(GalleryClassByRaw(6, 5, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data ->
                    println("---------- url -----------")
                    println(data)
                    println("---------- -- -----------")
                })

        compositeDisposable.add(ApiRequester.post(GalleryClassByForm(6, 5, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { data ->
                    println("---------- url -----------")
                    println(data)
                    println("---------- -- -----------")
                })

    }

    override fun onDestroy() {
        compositeDisposable.dispose()
        super.onDestroy()
    }

}
