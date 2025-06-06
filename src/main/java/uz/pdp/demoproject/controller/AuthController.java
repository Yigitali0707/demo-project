package uz.pdp.demoproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.demoproject.dto.LoginDto;
import uz.pdp.demoproject.dto.UserRegisterDto;
import uz.pdp.demoproject.interfaces.UserService;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

     private final UserService userService;
     @PostMapping("/login")
     public HttpEntity<?> login(@RequestBody LoginDto loginDto){
          return ResponseEntity.ok(userService.login(loginDto));
     }

     @PostMapping("/register")
     public HttpEntity<?> register(@RequestBody UserRegisterDto userRegisterDto){
          return ResponseEntity.ok(userService.register(userRegisterDto));
     }


     @PostMapping("/logout")
     public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
          SecurityContextHolder.clearContext();
          return ResponseEntity.ok("Logged out successfully");
     }
}
