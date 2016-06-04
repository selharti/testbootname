package com.ddx.devtests.testboot.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.ddx.devtests.testboot.domain"})
@EnableJpaRepositories(basePackages = {"com.ddx.devtests.testboot.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}

