package com.trodix.casbinserver.client.api.v1;


import com.trodix.casbinserver.client.EnforcerClient;
import com.trodix.casbinserver.client.oauth2.OAuth2Service;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnforcerApiTest {

    private EnforcerApi enforcer;

    @BeforeAll
    void init() {
        EnforcerClient client = new EnforcerClient().newBuilder()
                .baseUrl("http://localhost:7015")
                .oauth2(new OAuth2Service(
                        "http://localhost:8080/realms/market/protocol/openid-connect/token",
                        "duckcloud-webservice",
                        "mqZqOOLh9pUEXNclDI7k9Lz1AymXptWE"
                        )
                )
                .build();

        this.enforcer = new EnforcerApi(client);
    }

    @Test
    public void enforceTest() {
        assertTrue(enforcer.enforce("role:node:editor", "feature:node", "READ"));
    }

    @Test
    public void getPermittedActionsTest() {
        assertDoesNotThrow(() -> enforcer.getPermittedActions("user2", "feature:node:27"));
    }

}
