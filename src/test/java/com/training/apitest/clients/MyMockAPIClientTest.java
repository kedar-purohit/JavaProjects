package com.training.apitest.clients;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)
public class MyMockAPIClientTest {

    @Autowired
    private MyMockAPIClient myMockAPIClient;

    @Test
    public void testMockGetApi() {
        String result = myMockAPIClient.getMockApi();
        MatcherAssert.assertThat(result, Matchers.is("{\n  \"id\": 1,\n  \"value\": \"things\"\n}"));
    }

    @Test
    public void testMockPostApi() {
        String result = myMockAPIClient.postMockApi();
        MatcherAssert.assertThat(result, Matchers.is("Success"));
    }

}