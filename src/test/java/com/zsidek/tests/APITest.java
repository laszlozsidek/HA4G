package com.zsidek.tests;

import com.google.gson.JsonArray;
import com.zsidek.api.OkHttp;
import com.zsidek.utils.JsonUtil;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class APITest {

    private final OkHttp okHttp = new OkHttp();

    @Test
    public void testRestApi() throws IOException {
        try {
            Response response = okHttp.sendSyncGetRequest("https://jsonplaceholder.typicode.com/users");
            assertEquals(200, response.code(), "Response code should be 200");

            JsonArray jsonArray = JsonUtil.getJsonArray(response);

            jsonArray.forEach(e ->
                    System.out.printf("%s\t|%s\t%n",
                            JsonUtil.getJsonValueByKey(e, "name"),
                            JsonUtil.getJsonValueByKey(e, "email"))
            );

            assertTrue(jsonArray.get(0).getAsJsonObject().get("email").getAsString().contains("@"),
                    "Email of first item should contain @");
        } finally {
            okHttp.close();
        }
    }

}
