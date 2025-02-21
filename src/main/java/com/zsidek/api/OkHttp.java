package com.zsidek.api;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttp implements AutoCloseable {

    private Response response;

    public Response sendSyncGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        Call call = client.newCall(request);
        response = call.execute();
        return response;
    }

    @Override
    public void close() {
        response.close();
    }
}
