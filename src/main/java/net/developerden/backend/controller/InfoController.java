package net.developerden.backend.controller;

import net.developerden.backend.security.DiscordUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal DiscordUser principal) {
        return "Hello, " + principal.getName();
    }
}
