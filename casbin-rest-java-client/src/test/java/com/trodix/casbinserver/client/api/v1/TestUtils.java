package com.trodix.casbinserver.client.api.v1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trodix.casbinserver.client.exceptions.ApiException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class TestUtils {

    public static String getToken(String clientId, String clientSecret, String grantType) {
        try {
            OkHttpClient client = new OkHttpClient.Builder().build();
            RequestBody formBody = new FormBody.Builder()
                    .add("client_id", clientId)
                    .add("client_secret", clientSecret)
                    .add("grant_type", grantType)
                    .build();

            Request request = new Request.Builder()
                    .header("Content-Type", "x-www-form-urlencoded")
                    .url(String.format(
                            "http://localhost:8080/realms/market/protocol/openid-connect/token"
                    ))
                    .post(formBody)
                    .build();

            String responseBodyJson = client.newCall(request).execute().body().string();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseBodyJson);

            return root.get("access_token").asText();

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

}
