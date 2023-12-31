package org.zerock.apprds.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CustomServletConfig implements WebMvcConfigurer {
     //resource 설정
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/files/**")
                .addResourceLocations("classpath:/static/");
    }
    //cross origin 설정
    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/generateToken").allowedOrigins("*");
        registry.addMapping("/refreshAccessToken").allowedOrigins("*");

        registry.addMapping("/api/**").allowedOrigins("*");
    }
}
