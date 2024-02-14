package com.hasystem.apigw.controller;

import com.hasystem.apigw.config.ServiceProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("customer")
@RequiredArgsConstructor
public class CustomerController {
    private final ServiceProperties serviceProperties;

    @GetMapping("ping")
    public Mono<Map> ping() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        return WebClient.create(serviceProperties.getCustomerUrl())
                .get()
                .uri("ping")
                .retrieve()
                .bodyToMono(Map.class)
                .map(serviceRes -> {
                    Map res = new HashMap(serviceRes);
                    res.put("API-GW Hostname", localHost.getHostName());
                    return res;
                });
    }
}
