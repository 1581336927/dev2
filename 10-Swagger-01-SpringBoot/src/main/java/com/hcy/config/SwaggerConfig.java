package com.hcy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                //API基本信息
                .apiInfo(apiInfo())
                //对基本信息查询
                .select()
                //扫描指定包下的api
                .apis(RequestHandlerSelectors.basePackage("com.hcy"))
                //支持的任意路径
                .paths(PathSelectors.any())
                //构建
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api标题
                .title("Swagger测试")
                //api描述
                .description("第一次使用swagger")
                //联系人
                .contact(new Contact("Hancy", "hhtps://hithub.com/1581336927", "1581336927@qq.com"))
                //版本
                .version("1.0")
                //许可证
                .license("Apache 2.0")
                //服务条款
                .termsOfServiceUrl("https://swagger.io")
                .build();
    }
}
