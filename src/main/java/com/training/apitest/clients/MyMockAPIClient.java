package com.training.apitest.clients;

import com.training.apitest.model.RequestPojo;
import com.training.apitest.model.ResponsePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MyMockAPIClient {



    public String getMockApi() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("https://l1ry2.mocklab.io/json/1", String.class);
        String body = response.getBody();
        System.out.println("Body: " + body);
        return body;
    }

    public String postMockApi() {
        RestTemplate restTemplate = new RestTemplate();
        RequestPojo request = new RequestPojo(12345, "abc-def-ghi");
        ResponseEntity<ResponsePojo> responseEntity = restTemplate.postForEntity("https://l1ry2.mocklab.io/json", request, ResponsePojo.class);
        return responseEntity.getBody().getMessage();
    }




}
