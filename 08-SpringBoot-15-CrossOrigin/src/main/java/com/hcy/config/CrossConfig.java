package com.hcy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
public class CrossConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //控制器的访问路径
        registry.addMapping("/**")
                //允许携带cookie
                .allowCredentials(true)
                //允许模板源，注意如果允许使用cookie只能允许使用源
                .allowedOriginPatterns("*")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .maxAge(30*60);
    }
}
