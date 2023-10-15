package com.trodix.casbinserver.api.v1.requests;

public record AddNamedPolicyRequest(String ptype, String[] params) {
}
