package com.client.demo_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class MainController {
    @Autowired
    RestTemplate restTemplate;
    @GetMapping("/response/{id}")
    public String getResponse(@PathVariable String id){
        String response = restTemplate.getForObject("http://localhost:8080/hello-world/{id}",String.class,id);
        return response;
    }
    @Autowired
    WebClient.Builder builder;

    @GetMapping("/response1/{id}")
    public Mono<String> getResponse1(@PathVariable String id){
        WebClient webClient = builder.baseUrl("http://localhost:8080/hello-world").build();
        return webClient.get().uri("/{id}",id).retrieve().bodyToMono(String.class);
    }
}
