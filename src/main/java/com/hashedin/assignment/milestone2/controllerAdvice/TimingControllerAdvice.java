package com.hashedin.assignment.milestone2.controllerAdvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class TimingControllerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ServletServerHttpRequest servletServerRequest = (ServletServerHttpRequest) request;
        long startTime = (long) servletServerRequest.getServletRequest().getAttribute("startTime");
        long timeElapsed = (System.nanoTime() - startTime)/1000000;
        System.out.println("beforeBodyWrite:"+timeElapsed);
        response.getHeaders().add("X-TIME-TO-EXECUTE", String.valueOf(timeElapsed));
        return body;
    }
}