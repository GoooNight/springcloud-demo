package com.example.userservicedemo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootTest
class UserServiceDemoApplicationTests {

    @Test
    @SneakyThrows
    void contextLoads() {
        Mono<String> stringMono = WebClient.create().get()
                .uri("http://localhost:8080/user/getUsers")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToMono(String.class);
        stringMono.block();
    }

}
