package com.trodix.casbinserver.api.v1.requests;

public record RemoveFilteredGroupingPolicyRequest(int fieldIndex, String[] fieldValues) {
}
