package org.example.chronovaccin.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.chronovaccin.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        //1. try to extract the token
        String authHeader = request.getHeader("Authorization");
        String token = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
        }
        //2. if there is a token
        if (token != null) {
            //3. check if the token is valid
            if (jwtService.validateToken(token)) {
                //4. extract the username
                String username = jwtService.extractUsername(token);
                //5. load the user
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                //6. create the authentication
                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, new ArrayList<>());
                //7. set the authentication in the context
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        //8. continue the chain of filter
        filterChain.doFilter(request, response);
    }
}