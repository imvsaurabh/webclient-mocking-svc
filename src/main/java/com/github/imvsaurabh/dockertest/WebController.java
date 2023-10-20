package com.github.imvsaurabh.dockertest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private final WebClientService webClientService;

    public WebController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }

    @GetMapping
    public String welcome() {
        return "Spring Boot Application with Docker container!!! Yu hoo 😁";
    }

    @GetMapping(path = "/users")
    public String getUsers() {
        return webClientService.getUsers().block();
    }
}
