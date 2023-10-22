package com.trodix.casbinserver.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trodix.casbinserver.client.oauth2.AccessTokenInterceptor;
import com.trodix.casbinserver.client.oauth2.OAuth2Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnforcerClient {

    private static final Logger log = LoggerFactory.getLogger(EnforcerClient.class);

    private OkHttpClient httpClient;
    private Request.Builder requestBuilder;
    private ObjectMapper objectMapper;
    private String baseUrl;
    private OAuth2Service oauth2Service;

    public EnforcerClient() {
        this.requestBuilder = new Request.Builder()
                .header("Content-Type", "application/json");

        this.objectMapper = new ObjectMapper();
    }

    public OkHttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Request.Builder getRequestBuilder() {
        return requestBuilder;
    }

    public void setRequestBuilder(Request.Builder requestBuilder) {
        this.requestBuilder = requestBuilder;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public OAuth2Service getOauth2Service() {
        return oauth2Service;
    }

    public void setOauth2Service(OAuth2Service oauth2Service) {
        this.oauth2Service = oauth2Service;
    }

    public EnforcerClientBuilder newBuilder() {
        return new EnforcerClientBuilder();
    }

    public class EnforcerClientBuilder {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();

        public EnforcerClientBuilder() {

        }

        public EnforcerClientBuilder baseUrl(String _baseUrl) {
            baseUrl = _baseUrl;
            return this;
        }

        public EnforcerClientBuilder header(String name, String value) {
            requestBuilder = requestBuilder.header(name, value);
            return this;
        }

        public EnforcerClientBuilder oauth2(OAuth2Service _oauth2Service) {
            oauth2Service = _oauth2Service;
            return this;
        }

        public EnforcerClient build() {
            EnforcerClient client = new EnforcerClient();
            client.setBaseUrl(baseUrl);
            client.setRequestBuilder(requestBuilder);

            httpClientBuilder.addInterceptor(new AccessTokenInterceptor(oauth2Service));
            configureLoggingInterceptor();

            client.setHttpClient(httpClientBuilder.build());

            return client;
        }

        private void configureLoggingInterceptor() {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor((msg) -> {
                if (log.isTraceEnabled()) {
                    log.trace(msg);
                } else if (log.isDebugEnabled()) {
                    log.debug(msg);
                }
            });

            loggingInterceptor.redactHeader("Authorization");
            loggingInterceptor.redactHeader("Cookie");

            if (log.isTraceEnabled()) {
                loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
            } else if (log.isDebugEnabled()) {
                loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
            }

            httpClientBuilder.addInterceptor(loggingInterceptor);
        }

    }

}
