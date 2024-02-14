package com.hasystem.customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @GetMapping("ping")
    public Mono<Map<String, ?>> ping() throws UnknownHostException {
        return Mono.just(Map.of(
                "Result", new Date(),
                "Hostname", InetAddress.getLocalHost().getHostName()
        ));
    }
}
