package com.example.demo.config;

import com.example.demo.repository.DemandesDao;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    protected  AuthFilter authFilter(){
        return  new AuthFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/users/**","/user","/events","/upload","/updatepassword","/newforum","/forums/**"

                ,"/reply","/replies","/actualite","/replie","/forum","/newtask", "/alltasks/**", "/delete", "/newrec"
                        ,"/reclamation/**","/updatephone"

                ,"/updateemail","/formation/**","/getallformation","/recReplies","/replyRec",
                        "/updatephoto","/attestation",
                        "/fichedepaie/**","/mesnotification","/famille",
                        "/updateviewed","/monPointage","/notify"
                ,"/updateemail","/formation/**","/newdoc","/update/**","/getdoc","/getdemandes","/getallformation","/tableau/**",
                      "/updatephoto","/attestation","/fichedepaie/**","/famille","/mesformation").authenticated()
                .requestMatchers("/newevent","/newact", "/addpointage", "/newfiche").hasRole("ADMIN")
                .requestMatchers("/newdemande").hasAnyRole("USER","ChefDepartement","AdminFormation")
                .requestMatchers("/addformation","/addformationUser","/uploadformation").hasRole("AdminFormation")

                .requestMatchers("/auth","/image/**").permitAll()
                .and()
                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);




        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }



}

