package com.javamultiplex.client;

import com.javamultiplex.model.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Component
public class ProductApiClient {

    private final RestTemplate restTemplate;

    @Value("${product.api.root.url}")
    private String apiUrl;
    @Value("${product.api.user.name}")
    private String username;
    @Value("${product.api.user.password}")
    private String password;

    @Autowired
    public ProductApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ProductList getProducts(Integer customerId) {
        ResponseEntity<ProductList> responseEntity = restTemplate
                .exchange(apiUrl, HttpMethod.GET,new HttpEntity<>(buildHeaders()),ProductList.class, customerId);
        return responseEntity.getBody();
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders httpHeaders=new HttpHeaders();
        String usernameColonPassword = username + ":" + password;
        String headerValue="Basic "+ Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
        httpHeaders.add(HttpHeaders.AUTHORIZATION, headerValue);
        return httpHeaders;
    }
}
