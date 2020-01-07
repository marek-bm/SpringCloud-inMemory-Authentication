package com.mj.rental.auth.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {

    PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1")
                .password(passwordEncoder.encode("userpass"))
                .roles("USER", "ADMIN", "MANAGER")
                .authorities("CAN_READ", "CAN WRITE", "CAN DELETE")
                .and()
                .withUser("user2")
                .password(passwordEncoder.encode("userpass2"))
                .roles("USER")
                .authorities("CAN_READ", "CAN WRITE");
    }
}
