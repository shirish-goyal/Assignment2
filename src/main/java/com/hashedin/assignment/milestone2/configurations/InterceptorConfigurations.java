package com.hashedin.assignment.milestone2.configurations;

import com.hashedin.assignment.milestone2.interceptors.BasicAuthenticationInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfigurations implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        System.out.println("addInterceptors");
        registry.addInterceptor(new BasicAuthenticationInterceptors());
    }

}
