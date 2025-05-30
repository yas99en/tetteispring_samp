package com.example.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyAccessDeniedHandler implements AccessDeniedHandler {
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (response.isCommitted()) {
            return;
        }
        
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        try (PrintWriter writer = response.getWriter()) {
            writer.println("Access Denied!!");
        }
    }
}