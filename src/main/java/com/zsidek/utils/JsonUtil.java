package com.zsidek.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class JsonUtil {

    public static String getJsonValueByKey(JsonElement jsonElement, String key) {
        return jsonElement.getAsJsonObject().get(key).getAsString();
    }

    public static JsonArray getJsonArray(Response response) throws IOException {
        Gson gson = new Gson();
        String responseBody = Objects.requireNonNull(response.body()).string();
        return gson.fromJson(responseBody, JsonArray.class);
    }

}
