package com.shinn.sneakersshop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring boot sneaker shop REST APIs",
                description = "Spring boot sneaker shop REST APIs documentation",
                version = "1.0.0"

        )
)
public class SneakersShopApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SneakersShopApiApplication.class, args);
    }
}
