package net.developerden.backend.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

/* TODO we might wanna convert this to a database entity in the future so we can add more data*/

/**
 * Java representation of all of the data that Discord gives us from the /users/@me API endpoint.
 */
public record DiscordUser(String id, String username, String discriminator, String locale) implements OAuth2User {
    public String fullName() {
        return username + "#" + discriminator;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return Map.of(
                "id", id,
                "username", fullName(),
                "locale", locale
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getName() {
        return fullName();
    }
}
