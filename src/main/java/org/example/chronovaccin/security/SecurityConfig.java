package org.example.chronovaccin.security;

import org.example.chronovaccin.entities.User;
import org.example.chronovaccin.repository.UserRepository;
import org.example.chronovaccin.service.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtService jwtService;

    private final UserRepository userRepository;

    public SecurityConfig(JwtService jwtService, UserRepository userRepository, ClientRegistrationRepository clientRegistrationRepository) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/login**", "/webjars/**", "/error**", "/oauth2/authorization/**").permitAll() // Autorise l'accès à la page d'erreur OAuth2
                        .requestMatchers("/centers").hasRole("USER")
                        .requestMatchers("/doctors", "/doctor/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .successHandler(authenticationSuccessHandler())
                )
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter(jwtService);
    }


    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, authentication) -> {
            List<String> roles = getRolesFromUser(authentication);
            String token = jwtService.generateToken(authentication, roles);
            System.out.println(request.getRequestURI());
            System.out.println(token);
            response.sendRedirect("/dashboard"); // Redirige vers le dashboard avec le token
        };
    }

    private List<String> getRolesFromUser(Authentication authentication) {
        OAuth2User principal = (OAuth2User) authentication.getPrincipal();
        String userEmail = principal.getAttribute("email");

        List<String> roles = new ArrayList<>();
        User user = userRepository.findByEmail(userEmail); //Fetch the user from db
        if(user != null) { //check if user is found
            if (user.getIs_user()) {
                roles.add("ROLE_USER");
            }
            if (user.getIs_admin()) {
                roles.add("ROLE_ADMIN");
            }
        }

        System.out.println("Roles found with OAuth2 for user " + userEmail + ": " + roles);
        return roles.stream()
                .map(role -> role.startsWith("ROLE_") ? role : "ROLE_" + role)
                .toList();
    }

    @Bean
    public OAuth2AuthorizationRequestResolver authorizationRequestResolver(
            ClientRegistrationRepository clientRegistrationRepository) {

        DefaultOAuth2AuthorizationRequestResolver authorizationRequestResolver =
                new DefaultOAuth2AuthorizationRequestResolver(
                        clientRegistrationRepository, "/oauth2/authorization");
        authorizationRequestResolver.setAuthorizationRequestCustomizer(
                authorizationRequestCustomizer());

        return authorizationRequestResolver;
    }

    private java.util.function.Consumer<OAuth2AuthorizationRequest.Builder> authorizationRequestCustomizer() {
        return customizer -> {
            // nothing to customize
        };
    }


}