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
                        "cloud_name", "dttmksxud",
                        "api_key", "319538974549338",
                        "api_secret", "bR7yJx6p2MjuKThwfJzszIPFcXw"
                )
        );
    }
}