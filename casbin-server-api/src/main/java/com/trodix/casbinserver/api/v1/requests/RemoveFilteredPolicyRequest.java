package com.trodix.casbinserver.api.v1.requests;

public record RemoveFilteredPolicyRequest(int fieldIndex, String[] fieldValues) {
}
