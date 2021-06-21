package net.developerden.backend.security;

public record DiscordUser(String id, String username, String discriminator, String locale) {
}
