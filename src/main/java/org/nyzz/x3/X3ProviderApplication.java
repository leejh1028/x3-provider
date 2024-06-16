package org.nyzz.x3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class X3ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(X3ProviderApplication.class, args);
    }

}
