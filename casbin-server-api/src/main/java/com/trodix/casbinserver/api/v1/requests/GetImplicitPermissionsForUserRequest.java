package com.trodix.casbinserver.api.v1.requests;

public record GetImplicitPermissionsForUserRequest(String user, String[] domain) {
}
