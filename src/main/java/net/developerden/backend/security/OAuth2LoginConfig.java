package net.developerden.backend.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class OAuth2LoginConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(a ->
                a.antMatchers("/panel").authenticated()
                        .anyRequest().permitAll()
        )

                .oauth2Login()
                .userInfoEndpoint()
                .userService(new DiscordUserService());
    }
}
