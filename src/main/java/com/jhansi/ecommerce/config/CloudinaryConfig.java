package com.jhansi.ecommerce.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {

        return new Cloudinary(
                Map.of(
                        "cloud_name", "paste your name ",
                        "api_key", "paste your key",
                        "api_secret", "paste your secret"
                )
        );
    }
}
