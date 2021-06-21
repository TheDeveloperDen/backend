package net.developerden.backend.security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class DiscordUserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private static final String DISCORD_USERINFO_URI = "https://discord.com/api/users/@me";


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        final var headers = new HttpHeaders();

        final String authorization = userRequest.getAccessToken().getTokenType().getValue() + " " + userRequest.getAccessToken().getTokenValue();
        headers.add("Authorization", authorization);

        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        final var entity = new HttpEntity<>(headers);

        final var user = new RestTemplate()
                .exchange(DISCORD_USERINFO_URI, HttpMethod.GET,
                        entity, DiscordUser.class)
                .getBody();

        return user;
    }
}
