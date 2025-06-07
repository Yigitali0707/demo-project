package uz.pdp.demoproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.demoproject.entity.RefreshToken;
import uz.pdp.demoproject.entity.User;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUser(User user);
}