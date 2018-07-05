package com.sch.example.java.api.req;

import com.sch.retrofit.wrapper.request.params.FormParams;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import com.sch.example.java.api.resp.Data;

/**
 * Created by StoneHui on 2018/7/5.
 * <p>
 * Form 传参的请求
 */
public class GalleryClassByForm extends FormParams<Data> {

    public GalleryClassByForm(int id, int rows, int page) {
        super("tnfs/api/list");

        putUrlParams("id", id);
        putUrlParams("rows", rows);
        putUrlParams("page", page);

        putFormParams("id", id);
        putFormParams("rows", rows);
        putFormParams("page", page);
    }

    @NotNull
    @Override
    public Type getResponseType() {
        return Data.class;
    }
}
