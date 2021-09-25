package by.dz.test.test_project.controller;

import by.dz.test.test_project.dto.ProductRatingRequest;
import by.dz.test.test_project.dto.UserRequest;
import by.dz.test.test_project.mapper.UserMapper;
import by.dz.test.test_project.service.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasAuthority('USER')")
public class UserController {
    UserServiceImpl userService;
    UserMapper userMapper;

    UserController(UserServiceImpl userService, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        return ResponseEntity.ok(userService.getUserByEmail(authentication.getName()));
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestBody UserRequest newProfile) {
        return ResponseEntity.ok(userMapper.updateProfile(newProfile));
    }

    @PostMapping("/rateProduct")
    public ResponseEntity<?> rateProduct(@RequestBody ProductRatingRequest request) {
        return ResponseEntity.ok(userService.rateProduct(request));
    }
}
