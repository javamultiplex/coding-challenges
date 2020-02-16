package com.javamultiplex.client;

import com.javamultiplex.model.Product;
import com.javamultiplex.model.ProductList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

/**
 * @author Rohit Agarwal on 15/02/20 9:16 pm
 * @copyright www.javamultiplex.com
 */
@Component
public class ProductApiClient {

    private final RestTemplate restTemplate;

    @Value("${product.api.url}")
    private String apiUrl;
    @Value("${product.api.user.name}")
    private String username;
    @Value("${product.api.user.password}")
    private String password;

    @Autowired
    public ProductApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackProducts",
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")

    },
    threadPoolKey = "productService",
    threadPoolProperties = {
            @HystrixProperty(name = "coreSize",value = "20"),
            @HystrixProperty(name = "maxQueueSize",value = "10")
    })
    public ProductList getProducts(Integer customerId) {
        ResponseEntity<ProductList> responseEntity = restTemplate
                .exchange(apiUrl, HttpMethod.GET, new HttpEntity<>(buildHeaders()), ProductList.class, customerId);
        return responseEntity.getBody();
    }

    public ProductList getFallbackProducts(Integer customerId) {
        ProductList productList=new ProductList();
        productList.getProducts().add(new Product(1, "Microwave","LG_2019"));
        return productList;
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        String usernameColonPassword = username + ":" + password;
        String headerValue = "Basic " + Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
        httpHeaders.add(HttpHeaders.AUTHORIZATION, headerValue);
        return httpHeaders;
    }
}
