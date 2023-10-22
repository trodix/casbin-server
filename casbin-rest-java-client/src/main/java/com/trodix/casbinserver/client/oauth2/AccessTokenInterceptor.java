package com.trodix.casbinserver.client.oauth2;

import okhttp3.*;

import java.io.IOException;

public class AccessTokenInterceptor implements Interceptor {
    private final OAuth2Service oauth2Service;

    public AccessTokenInterceptor(OAuth2Service oauth2Service) {
        this.oauth2Service = oauth2Service;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        final TokenResponse tokenStorage = oauth2Service.getAccessToken();

        Request request = newRequestWithAccessToken(chain.request(), tokenStorage.getAccessToken());

        return chain.proceed(request);
    }

    private Request newRequestWithAccessToken(Request request, String accessToken) {
        return request.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .build();
    }

}
