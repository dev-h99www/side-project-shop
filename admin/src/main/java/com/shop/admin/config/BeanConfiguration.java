package com.shop.admin.config;

import com.shop.admin.common.BcryptImpl;
import com.shop.admin.common.EncryptHelper;
import com.shop.admin.common.TokenProvider;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.shop.admin")
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
