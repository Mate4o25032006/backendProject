package com.backend.backendProject.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    //Provee detalles de usuarios
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails userTeo = User.withUsername("userTeo")
                .password(passwordEncoder().encode("teo123"))
                .build();
        return new InMemoryUserDetailsManager(userTeo);
    }

    //Encriptar Contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    //Filtro de seguridad para aprobar peticiones
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer :: disable)
                .authorizeHttpRequests((authorize) -> {
                    authorize.anyRequest().permitAll();
                }).httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
}
