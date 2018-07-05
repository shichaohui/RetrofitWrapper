package com.sch.example.java.api.req;

import com.sch.retrofit.wrapper.request.params.UrlParams;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

import com.sch.example.java.api.resp.Data;

/**
 * Created by StoneHui on 2018/7/5.
 * <p>
 * Url 传参的请求。
 */
public class GalleryClassByUrl extends UrlParams<Data> {

    public GalleryClassByUrl(int id, int rows, int page) {
        super("tnfs/api/list");

        putUrlParams("id", id);
        putUrlParams("rows", rows);
        putUrlParams("page", page);
    }

    @NotNull
    @Override
    public Type getResponseType() {
        return Data.class;
    }
}