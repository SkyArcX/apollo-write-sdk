package com.bluesky.apollo.core;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;

public class ApolloConfigServiceCoreTest {

    private ApolloClient mockClient;
    private ApolloConfigServiceCore service;

    @BeforeEach
    public void setUp() {
        mockClient = Mockito.mock(ApolloClient.class);
        service = new ApolloConfigServiceCore(mockClient);
    }

    public void testPublishSingle() throws Exception{
        // 模拟create item成功
        when(mockClient.post(contains("/items"), ·anyString())).thenReturn("{}");
    }
}
