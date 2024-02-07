package com.innovation.biometric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@ComponentScan(basePackages ="com.innovation.biometric")
public class BiometricApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiometricApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type","Accept","Jwt-Token","Authorization",
		"Origin","Accept","X-Requested-With","Access-Control-Request-Method","Access-Control-Request-Headers","no-auth"
		));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Jwt-Token","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Origin",
				"Access-Control-Allow-Credentials","File-Name"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PATCH","PUT","DELETE","OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
