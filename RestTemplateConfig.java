package com.premierleague.teamstats;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//rest template for external api call.
@Configuration
public class RestTemplateConfig {

	//https://api.msmc.cc
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
       return builder.build();
    }
	


}
