package com.trodix.casbinserver.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;

public class EnforcerClient {

    private HttpClient httpClient;
    private ObjectMapper objectMapper;

    private String baseUrl;
    private Map<String, String> headers;

    public EnforcerClient() {
        this.httpClient = HttpClient.newBuilder().build();
        this.objectMapper = new ObjectMapper();
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setClient(HttpClient client) {
        this.httpClient = client;
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

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public EnforcerClientBuilder newBuilder() {
        return new EnforcerClientBuilder();
    }

    public class EnforcerClientBuilder {

        private String _baseUrl;
        private Map<String, String> _headers = new HashMap<>();

        public EnforcerClientBuilder() {
            _headers.put("Content-Type", "application/json");
        }

        public EnforcerClientBuilder baseUrl(String baseUrl) {
            _baseUrl = baseUrl;
            return this;
        }

        public EnforcerClientBuilder header(String name, String value) {
            _headers.put(name, value);
            return this;
        }

        public EnforcerClient build() {
            EnforcerClient client = new EnforcerClient();
            client.setBaseUrl(_baseUrl);
            client.setHeaders(_headers);

            return client;
        }

    }

}
