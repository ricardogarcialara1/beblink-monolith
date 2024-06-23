package com.beblink.config.security;

import com.beblink.config.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The type Http security config.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity()
public class HttpSecurityConfig {

    /**
     * Security filter chain security filter chain.
     *
     * @param http                   the http
     * @param authenticationProvider the authentication provider
     * @param authenticationFilter   the authentication filter
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationProvider authenticationProvider, JwtAuthenticationFilter authenticationFilter) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);
                //.authorizeHttpRequests(builderRequestMatchers());
        return http.build();
    }

}
