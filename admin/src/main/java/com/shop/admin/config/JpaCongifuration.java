package com.shop.admin.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.QueryLookupStrategy;

@Configuration
@EntityScan(basePackages = "com.shop.admin")
@EnableJpaRepositories(basePackages = "com.shop.admin", queryLookupStrategy = QueryLookupStrategy.Key.CREATE_IF_NOT_FOUND)
public class JpaCongifuration {
}
