package com.github.imvsaurabh.dockertest;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WebClientService {

    private final WebClient webClient;

    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(String.class);
    }
}

