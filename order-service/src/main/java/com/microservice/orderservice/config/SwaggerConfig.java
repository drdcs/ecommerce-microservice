package com.microservice.orderservice.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("orders-api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.microservice.orderservice.controller"))
                .paths(PathSelectors.any())
                .build();

    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Orders API")
                .description("Order API microservices ")
                .licenseUrl("test@email.com")
                .version("1.0")
                .build();
    }
}
