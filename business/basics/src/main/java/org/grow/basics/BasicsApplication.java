package org.grow.basics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Random;


@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class BasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicsApplication.class, args);
	}
	@Bean
	public Random random(){
		return new Random();
	}
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("org.grow.basics.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("Spring Boot中使用Swagger构建Rest Api version Member")
				.version("1.0").build();
	}
}
