package com.zsidek.tests;

import com.google.gson.JsonArray;
import com.zsidek.api.OkHttp;
import com.zsidek.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.zsidek.utils.StringConstants.EMAIL;
import static com.zsidek.utils.StringConstants.NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class APITest {

    private OkHttp okHttp;

    @BeforeEach
    public void setUp() {
        okHttp = new OkHttp();
    }

    @AfterEach
    public void tearDown() {
        okHttp.close();
    }

    @Test
    public void testRestApi() throws IOException {
        Response response = okHttp.sendSyncGetRequest("https://jsonplaceholder.typicode.com/users");
        assertEquals(200, response.code(), "Response code should be 200");

        JsonArray jsonArray = JsonUtil.getJsonArray(response);

        jsonArray.forEach(e ->
                log.info("{}\t|\t{}",
                        JsonUtil.getJsonValueByKey(e, NAME),
                        JsonUtil.getJsonValueByKey(e, EMAIL))
        );

        assertTrue(jsonArray.get(0).getAsJsonObject().get(EMAIL).getAsString().contains("@"),
                "Email of first item should contain @");
    }

}
