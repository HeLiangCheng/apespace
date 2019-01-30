package com.hlc.apespace.gathering.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
    *@ClassName SwaggerConfig
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 10:24
    *@Version 1.0
**/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hlc.apespace.gathering"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("apespace_faqs在线接口文档")
                .description("Spring Boot中使用Swagger2构建RESTful APIs")
                .termsOfServiceUrl("")
                .contact(new Contact("heliangcheng", "", "hlc19890519@126.com"))
                .version("1.0")
                .build();
    }

}
