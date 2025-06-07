package uz.pdp.demoproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.demoproject.entity.RefreshToken;
import uz.pdp.demoproject.entity.User;
import uz.pdp.demoproject.repository.RefreshTokenRepository;
import uz.pdp.demoproject.security.JwtUtils;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtils jwtUtils;

    private final Duration REFRESH_TOKEN_DURATION = Duration.ofDays(7);

    public RefreshToken createRefreshToken(User user) {
        String token = jwtUtils.generateRandomToken();
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setToken(token);
        refreshToken.setExpiryDate(LocalDateTime.now().plus(REFRESH_TOKEN_DURATION));
        refreshToken.setRevoked(false);
        return refreshTokenRepository.save(refreshToken);
    }

    public RefreshToken validateToken(String token) {
        return refreshTokenRepository.findByToken(token)
                .filter(rt -> !rt.isExpired() && !rt.isRevoked())
                .orElseThrow(() -> new RuntimeException("Invalid or expired refresh token"));
    }

    public void revokeToken(RefreshToken token) {
        token.setRevoked(true);
        refreshTokenRepository.save(token);
    }

    public void revokeUserTokens(User user) {
        refreshTokenRepository.deleteByUser(user);
    }
}
