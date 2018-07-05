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

package com.sch.example.java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sch.retrofit.wrapper.ApiRequester;
import com.sch.retrofit.wrapper.RetrofitWrapper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import stonehui.retrofitwrapper.R;

import com.sch.example.java.api.req.GalleryClassByForm;
import com.sch.example.java.api.req.GalleryClassByRaw;
import com.sch.example.java.api.req.GalleryClassByUrl;
import com.sch.example.java.api.resp.Data;

/**
 * Created by StoneHui on 2017/8/5.
 * <p>
 * 返回数据。
 */
public class MainActivity extends AppCompatActivity {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitWrapper.init("http://www.tngou.net/");

        compositeDisposable.add(ApiRequester.get(new GalleryClassByUrl(6, 5, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Data>() {
                    @Override
                    public void accept(Data data) throws Exception {
                        System.out.println("---------- url -----------");
                        System.out.println(data);
                        System.out.println("---------- -- -----------");
                    }
                }));

        compositeDisposable.add(ApiRequester.post(new GalleryClassByRaw(6, 5, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Data>() {
                    @Override
                    public void accept(Data data) throws Exception {
                        System.out.println("---------- url -----------");
                        System.out.println(data);
                        System.out.println("---------- -- -----------");
                    }
                }));

        compositeDisposable.add(ApiRequester.post(new GalleryClassByForm(6, 5, 1))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Data>() {
                    @Override
                    public void accept(Data data) throws Exception {
                        System.out.println("---------- url -----------");
                        System.out.println(data);
                        System.out.println("---------- -- -----------");
                    }
                }));

    }

    @Override
    protected void onDestroy() {
        compositeDisposable.dispose();
        super.onDestroy();
    }

}
