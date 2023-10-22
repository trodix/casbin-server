package com.trodix.casbinserver.client.oauth2;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trodix.casbinserver.client.exceptions.ApiException;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import java.time.Instant;

public class OAuth2Service {

    private String tokenUrl;
    private String clientId;
    private String clientSecret;

    private ObjectMapper mapper;

    private TokenResponse tokenRepository;

    public OAuth2Service(String tokenUrl, String clientId, String clientSecret) {
        this.mapper = new ObjectMapper();

        this.tokenUrl = tokenUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public TokenResponse getAccessToken() {

        if (tokenRepository == null || isAccessTokenExpired()) {
            try {
                OkHttpClient client = new OkHttpClient.Builder().build();
                RequestBody formBody = new FormBody.Builder()
                        .add("client_id", clientId)
                        .add("client_secret", clientSecret)
                        .add("grant_type", "client_credentials")
                        .build();

                Request request = new Request.Builder()
                        .header("Content-Type", "x-www-form-urlencoded")
                        .url(tokenUrl)
                        .post(formBody)
                        .build();

                String responseBodyJson = client.newCall(request).execute().body().string();
                tokenRepository = mapper.readValue(responseBodyJson, TokenResponse.class);

            } catch (Exception e) {
                throw new ApiException(e);
            }
        }

        return tokenRepository;
    }

    protected boolean isAccessTokenExpired() {
        DecodedJWT jwt = JWT.decode(tokenRepository.getAccessToken());
        Instant expiredDate = jwt.getExpiresAtAsInstant();
        return expiredDate.isBefore(Instant.now());
    }
}
