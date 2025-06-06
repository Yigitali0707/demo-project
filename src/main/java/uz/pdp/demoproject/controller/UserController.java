package uz.pdp.demoproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.demoproject.dto.UserInfoDto;
import uz.pdp.demoproject.interfaces.UserService;

@RestController
@RequestMapping("/api/userinfo")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public HttpEntity<?> getAllUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.getAllUser(page,size));
    }


    @GetMapping
    public HttpEntity<?> getCurrentUser(){
         return ResponseEntity.ok(userService.getUserInfo());
    }


    @PutMapping
    public HttpEntity<?> updateUserInfo(UserInfoDto userInfoDto){
        return ResponseEntity.ok(userService.updateUserInfo(userInfoDto));
    }

    @DeleteMapping
    public HttpEntity<?> deleteUser(){
        return ResponseEntity.ok(userService.deleteUser());
    }
}
