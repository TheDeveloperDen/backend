package net.developerden.backend.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevDenUserRepository extends JpaRepository<DevDenUser, Long> {
}
