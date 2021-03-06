package com.bingdou.tools;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * JSON������
 */
public class JsonUtil {

    private static Gson gson = new GsonBuilder().create();
    private static Gson gsonFormat = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private static JsonParser jsonParser = new JsonParser();

    private JsonUtil() {
    }

    public static JsonElement bean2JsonTree(Object bean) {
        return gson.toJsonTree(bean);
    }

    public static <T> T jsonStr2Bean(String jsonStr, Class<T> clazz) {
        return gson.fromJson(jsonStr, clazz);
    }

    public static String bean2JsonStr(Object bean) {
        return gson.toJson(bean);
    }

    public static String formatJsonStr(String jsonStr) {
        return gsonFormat.toJson(jsonParser.parse(jsonStr));
    }

}
