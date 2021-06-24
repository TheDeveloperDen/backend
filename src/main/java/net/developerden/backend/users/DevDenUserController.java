package net.developerden.backend.users;

import net.developerden.backend.security.DiscordUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DevDenUserController {
    private final DevDenUserRepository repository;

    public DevDenUserController(DevDenUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users/me")
    public Optional<DevDenUser> getMe(@AuthenticationPrincipal DiscordUser user) {
        return repository.findById(Long.valueOf(user.id()));
    }

    @GetMapping("/users/{id}")
    public Optional<DevDenUser> getById(@AuthenticationPrincipal DiscordUser user, @PathVariable Optional<Long> id) {
        return id.flatMap(repository::findById);
    }

}
