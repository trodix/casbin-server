package com.trodix.casbinserver.client.api.v1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.trodix.casbinserver.client.EnforcerClient;
import com.trodix.casbinserver.client.exceptions.ApiException;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EnforcerApi {

    private final EnforcerClient client;

    public EnforcerApi(EnforcerClient client) {
        this.client = client;
    }

    public boolean enforce(String... rvals) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/enforce"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "rvals", rvals
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean removePolicy(String... params) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/remove-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "params", params
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean removeFilteredPolicy(int fieldIndex, String... fieldValues) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/remove-filtered-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "fieldIndex", fieldIndex,
                                            "fieldValues", fieldValues
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean removeFilteredGroupingPolicy(int fieldIndex, String... fieldValues) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/remove-filtered-grouping-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "fieldIndex", fieldIndex,
                                            "fieldValues", fieldValues
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean addPolicy(String... params) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/add-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "params", params
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean hasPolicy(String... params) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/has-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "params", params
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean hasGroupingPolicy(String... params) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/has-grouping-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "params", params
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean addNamedPolicy(String ptype, String... params) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/add-named-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "ptype", ptype,
                                            "params", params
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public boolean addNamedGroupingPolicy(String ptype, String... params) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/add-named-grouping-policy"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "ptype", ptype,
                                            "params", params
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllActions() throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/get-all-actions"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllObjects() throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/get-all-objects"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllRoles() throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/get-all-roles"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getAllSubjects() throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/get-all-subjects"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<List<String>> getImplicitPermissionsForUser(String user, String... domain) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/get-implicit-permissions-for-user"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "user", user,
                                            "domain", domain
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public List<String> getRolesForUser(String name) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/get-roles-for-user"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "name", name
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    public Set<String> getPermittedActions(String subject, String object) throws ApiException {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder();

            for (Map.Entry<String, String> header : client.getHeaders().entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }

            HttpRequest httpRequest = builder.uri(new URI(client.getBaseUrl() + "/api/v1/authorization/get-permitted-actions"))
                    .POST(HttpRequest.BodyPublishers.ofString(
                            client.getObjectMapper().writeValueAsString(
                                    Map.of(
                                            "subject", subject,
                                            "object", object
                                    )
                            )
                    ))
                    .build();

            HttpResponse<String> response = client.getHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() / 100 == 2) {
                String bodyResponse = response.body();
                return client.getObjectMapper().readValue(bodyResponse, new TypeReference<>() {
                });
            }

            throw new ApiException(String.format("response code: %s\nresponse body: \n%s",
                    response.statusCode(), client.getObjectMapper().readValue(response.body(), String.class)));

        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

}
