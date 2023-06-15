package com.cybersoft.springboot_cozastore.filter;

import com.cybersoft.springboot_cozastore.jwt.JwtHelper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // get token from header
        try {
            String bearerToken = request.getHeader("Authorization");
            if(bearerToken.startsWith("Bearer ")){
                bearerToken = bearerToken.substring(6);
                Claims claims = jwtHelper.decodeToken(bearerToken);
                if(claims!=null){
                    SecurityContext securityContext = SecurityContextHolder.getContext();
                    securityContext.setAuthentication(new UsernamePasswordAuthenticationToken("","",new ArrayList<>()));
                }

            }
        }catch (Exception e){
            System.out.println("Error at doFilterInternal");
        }

        filterChain.doFilter(request,response);

    }
}
