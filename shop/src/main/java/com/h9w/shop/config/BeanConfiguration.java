package com.h9w.shop.config;

import com.h9w.shop.common.BcryptImpl;
import com.h9w.shop.common.EncryptHelper;
import com.h9w.shop.common.TokenProvider;
import com.h9w.shop.config.CustomModelMapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.h9w.shop")
public class BeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        return new CustomModelMapper();
    }

    @Bean
    public EncryptHelper encryptHelper() {

        return new BcryptImpl();
    }

    @Bean
    public TokenProvider tokenProvider() {

        return new TokenProvider();
    }
}
