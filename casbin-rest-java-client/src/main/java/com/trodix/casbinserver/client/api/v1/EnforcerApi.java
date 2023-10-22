package com.trodix.casbinserver.client.api.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trodix.casbinserver.client.EnforcerClient;
import com.trodix.casbinserver.client.exceptions.ApiException;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnforcerApi {

    private final EnforcerClient client;

    public EnforcerApi(EnforcerClient client) {
        this.client = client;
    }

    private <T> T handleResponse(Response response) throws IOException {
        if (response.isSuccessful()) {
            String bodyResponse = response.body().string();
            return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
            });
        }

        throw new ApiException(String.format("\nresponse code: %s\nresponse body: \n%s",
                response.code(), response.body().string()));
    }

    public boolean enforce(String... rvals) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("rvals", rvals))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/enforce")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean removePolicy(String... params) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("params", params))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/remove-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean removeFilteredPolicy(int fieldIndex, String... fieldValues) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("fieldIndex", fieldIndex, "fieldValues", fieldValues))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/remove-filtered-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean removeFilteredGroupingPolicy(int fieldIndex, String... fieldValues) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of(
                                    "fieldIndex", fieldIndex,
                                    "fieldValues", fieldValues
                            ))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/remove-filtered-grouping-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean addPolicy(String... params) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("params", params))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/add-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean hasPolicy(String... params) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("params", params))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/has-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean hasGroupingPolicy(String... params) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("params", params))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/has-grouping-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean addNamedPolicy(String ptype, String... params) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("ptype", ptype, "params", params))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/add-named-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean addNamedGroupingPolicy(String ptype, String... params) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("ptype", ptype, "params", params))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/add-named-grouping-policy")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllActions() throws ApiException {
        try {

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/get-all-actions")
                    .get()
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllObjects() throws ApiException {
        try {

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/get-all-objects")
                    .get()
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllRoles() throws ApiException {
        try {

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/get-all-roles")
                    .get()
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllSubjects() throws ApiException {
        try {

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/get-all-subjects")
                    .get()
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<List<String>> getImplicitPermissionsForUser(String user, String... domain) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("user", user, "domain", domain))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/get-implicit-permissions-for-user")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getRolesForUser(String name) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("name", name))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/get-roles-for-user")
                    .post(requestBody)
                    .build();

            return handleResponse(client.getHttpClient().newCall(httpRequest).execute());

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public Set<String> getPermittedActions(String subject, String object) throws ApiException {
        try {

            RequestBody requestBody = RequestBody.create(
                    client.getObjectMapper()
                            .writeValueAsString(Map.of("subject", subject, "object", object))
                            .getBytes()
            );

            Request httpRequest = client.getRequestBuilder()
                    .url(client.getBaseUrl() + "/api/v1/authorization/get-permitted-actions")
                    .post(requestBody)
                    .build();

            return new HashSet<>(handleResponse(client.getHttpClient().newCall(httpRequest).execute()));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

}
