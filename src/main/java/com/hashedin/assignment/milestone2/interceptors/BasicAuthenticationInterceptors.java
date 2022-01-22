package com.hashedin.assignment.milestone2.interceptors;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicAuthenticationInterceptors extends HandlerInterceptorAdapter {

    Long startTime;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("preHandle");
        startTime = System.nanoTime();
        request.setAttribute("startTime",startTime);
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null){
            return true;
        } else {
            response.sendError(401, "Unauthorized");
            return  false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
//        long executionTime = (System.nanoTime()-startTime)/1000000;
//        System.out.println(executionTime);
//        System.out.println(response.getHeaderNames());

//        response.setHeader("X-TIME-TO-EXECUTE", String.valueOf(executionTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("After Completion");
    }

}
