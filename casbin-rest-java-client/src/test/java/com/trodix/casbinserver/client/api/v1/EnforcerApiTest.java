package com.trodix.casbinserver.client.api.v1;


import com.trodix.casbinserver.client.EnforcerClient;
import com.trodix.casbinserver.client.api.v1.EnforcerApi;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnforcerApiTest {

    @Test
    @Disabled
    public void enforceTest() {

        String token = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJGTDhTS2pZcU85NWFqQ3NmS3I4ZndhaFoxanM0dVRjbkZYbk5MMmZtOGNnIn0.eyJleHAiOjE2OTczODM2NjgsImlhdCI6MTY5NzM4MzM2OCwianRpIjoiN2U0MjQwZWQtYWMzYS00ZWZhLTlkODItNTBkYmE0MWVlYzgyIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9tYXJrZXQiLCJhdWQiOlsicmVhbG0tbWFuYWdlbWVudCIsInF1YWNrLWR1Y2stZWNtLXVpIiwibWFya2V0LWJhY2tlbmQiLCJxdWFjay1kdWNrLWVjbS1hcGkiLCJhY2NvdW50Il0sInN1YiI6IjM5ZjYwMGFiLTFhNjktNGU0Ny05NjhiLTMwMjNkMWQ3MTYwMCIsInR5cCI6IkJlYXJlciIsImF6cCI6ImR1Y2tjbG91ZC13ZWJzZXJ2aWNlIiwiYWNyIjoiMSIsInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW1hcmtldCIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJhcHAtdXNlciJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InJlYWxtLW1hbmFnZW1lbnQiOnsicm9sZXMiOlsidmlldy11c2VycyIsIm1hbmFnZS1jbGllbnRzIiwicXVlcnktZ3JvdXBzIiwicXVlcnktdXNlcnMiXX0sInF1YWNrLWR1Y2stZWNtLXVpIjp7InJvbGVzIjpbImVjbS11aS11c2VyIl19LCJtYXJrZXQtYmFja2VuZCI6eyJyb2xlcyI6WyJtYXJrZXQtY3VzdG9tZXIiXX0sInF1YWNrLWR1Y2stZWNtLWFwaSI6eyJyb2xlcyI6WyJlY20tdXNlciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwiY2xpZW50SWQiOiJkdWNrY2xvdWQtd2Vic2VydmljZSIsImNsaWVudEhvc3QiOiIxNzIuMjYuMC4xIiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtZHVja2Nsb3VkLXdlYnNlcnZpY2UiLCJjbGllbnRBZGRyZXNzIjoiMTcyLjI2LjAuMSJ9.XCj1RUfsmxLKSfup_cJdBLAVTJgG1EjYpBPMzxIggMqDehmUArSB7oRs8uD8biKsGKYUQF6VCoQy4A2ixI5bhe0h5FHczRddxAGbbjMoElQ8LLLOjrHCLIwmYISpZTafBm6sX3neKHhlb_kDLcD47GBH2gTVCmPz3aQdR4ngDW7I7hzoHJy3T0mqp6XgctymexH1BjxD3VD7Sr5mYO-bEgx0SwZ0P4RinXUBPLz66rFJQveeUpwd5IuFgs4VGJ0IrXiLLo91YZOjiftFmDogfoOacJxq5B8eIjjXRmGDDpRMAGmz5clZ4Am51f9LKpLs3qdotlmzWCFUh33zqYwfvQ";

        EnforcerClient client = new EnforcerClient().newBuilder()
                .header("Authorization", "Bearer " + token)
                .baseUrl("http://localhost:7015")
                .build();

        EnforcerApi api = new EnforcerApi(client);

        assertTrue(api.enforce("role:node:editor", "feature:node", "READ"));
    }

}
