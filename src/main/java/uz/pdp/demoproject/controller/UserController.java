package uz.pdp.demoproject.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.pdp.demoproject.dto.UserInfoDto;
import uz.pdp.demoproject.interfaces.UserService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    @GetMapping("/admin/userinfo/all")
    public HttpEntity<?> getAllUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userService.getAllUser(page,size));
    }


    @GetMapping("/user/userinfo")
    public HttpEntity<?> getCurrentUser(){
         return ResponseEntity.ok(userService.getUserInfo());
    }


    @PutMapping("/user/userinfo")
    public HttpEntity<?> updateUserInfo(UserInfoDto userInfoDto){
        return ResponseEntity.ok(userService.updateUserInfo(userInfoDto));
    }

    @DeleteMapping("/user/userinfo")
    public HttpEntity<?> deleteUser(){
        return ResponseEntity.ok(userService.deleteUser());
    }
}
