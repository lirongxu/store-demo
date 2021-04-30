package com.lemon.store.config;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author lemon
 * @Date 2021/4/30
 */
@Configuration
@Import(ConsulProperties.class)
public class ConsulConfig {

    @Bean
    public Consul consul(ConsulProperties consulProperties) {

        Consul consul = Consul.builder()
                .withHostAndPort(HostAndPort.fromParts(consulProperties.getHost(), consulProperties.getPort()))
                .withAclToken(consulProperties.getToken())
                .build();
        return consul;
    }
}
