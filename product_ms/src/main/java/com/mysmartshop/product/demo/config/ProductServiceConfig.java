package com.mysmartshop.product.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ProductServiceConfig {
	@Bean
	public RestTemplate getRestTemplate() {
	RestTemplate restClient=new RestTemplate();
    return restClient;
}

}
