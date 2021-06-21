package net.developerden.backend.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import java.util.Collections;

@EnableWebSecurity
public class OAuth2LoginConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a ->
                a.antMatchers("/", "/error").permitAll()
                        .anyRequest().authenticated()
        )

                .oauth2Login()
                .userInfoEndpoint()
                .userService(new DiscordUserService());
    }
}
