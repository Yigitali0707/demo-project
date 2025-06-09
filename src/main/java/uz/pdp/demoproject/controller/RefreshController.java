package uz.pdp.demoproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import uz.pdp.demoproject.dto.TokenDto;
import uz.pdp.demoproject.entity.RefreshToken;
import uz.pdp.demoproject.entity.User;
import uz.pdp.demoproject.security.JwtUtils;
import uz.pdp.demoproject.service.RefreshTokenService;
import uz.pdp.demoproject.service.UserServiceImpl;

import java.util.Map;

@RestController
@RequestMapping("/api/refreshToken")
@RequiredArgsConstructor
public class RefreshController {
    private final RefreshTokenService refreshTokenService;
    private final JwtUtils jwtUtils;

    @PostMapping
    public ResponseEntity<TokenDto> refresh(@RequestBody Map<String, String> request) {
        String token = request.get("refreshToken");

        RefreshToken oldToken = refreshTokenService.validateToken(token);
        User user = oldToken.getUser();

        refreshTokenService.revokeToken(oldToken);
        RefreshToken newToken = refreshTokenService.createRefreshToken(user);
        String newAccessToken = jwtUtils.generateToken(user.getUsername(), user.getRoles());

        return ResponseEntity.ok(new TokenDto(newAccessToken, newToken.getToken()));
    }
}
