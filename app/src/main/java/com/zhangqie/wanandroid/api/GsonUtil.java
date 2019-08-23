package com.zhangqie.wanandroid.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author: ${bruce}
 * @project: wanandroid-master
 * @package: com.zhangqie.wanandroid.api
 * @description:
 * @date: 2019/8/23
 * @time: 14:38
 */
public class GsonUtil {
    private static final GsonUtil instance;

    private final Gson mGson;

    static {
        instance = new GsonUtil();
    }

    private GsonUtil() {
        mGson = new GsonBuilder()
                .setLenient()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
                .serializeNulls()
                .create();
    }

    public static Gson getGson() {
        return instance.mGson;
    }

    public static Object JSONToObject(String json, Class beanClass) {
        Gson gson = new Gson();
        Object res = gson.fromJson(json, beanClass);
        return res;
    }
}
