package com.ddx.devtests.testboot;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class TestbootnameApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(TestbootnameApplication.class, args);
		
		/* for test only
		System.out.println("STARTING =======================");
	
		System.out.println("Let's inspect the beans provided by Spring Boot:");

	        String[] beanNames = applicationContext.getBeanDefinitionNames();
	        Arrays.sort(beanNames);
	        for (String beanName : beanNames) {
	            System.out.println(beanName);
	        }
	        System.out.println("BEANS END =======================");
		*/
		
	}
	/*
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.US);
	    return slr;
	}
	*/
}
