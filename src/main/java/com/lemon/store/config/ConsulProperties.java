package com.lemon.store.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lemon
 * @Date 2021/4/30
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "consul")
public class ConsulProperties {
    private String host;

    private Integer port;

    private String token;
}
