package com.sch.example.java.api.req;

import com.sch.retrofit.wrapper.request.SupportHeaders;
import com.sch.retrofit.wrapper.request.params.RawParams;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.sch.example.java.api.resp.Data;

/**
 * Created by StoneHui on 2018/7/5.
 * <p>
 * Raw 传参的请求。
 */
public class GalleryClassByRaw extends RawParams<Data> implements SupportHeaders {

    public GalleryClassByRaw(int id, int rows, int page) {
        super("tnfs/api/list");

        putUrlParams("id", id);
        putUrlParams("rows", rows);
        putUrlParams("page", page);

        putRawParams("id", id);
        putRawParams("rows", rows);
        putRawParams("page", page);
    }

    @NotNull
    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json; charset=utf-8");
        return headers;
    }

    @NotNull
    @Override
    public Type getResponseType() {
        return Data.class;
    }
}