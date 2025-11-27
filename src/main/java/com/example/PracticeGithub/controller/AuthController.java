package com.example.PracticeGithub.controller;

import com.example.PracticeGithub.dto.ApiResponse;
import com.example.PracticeGithub.dto.LoginRequest;
import com.example.PracticeGithub.service.AuthService;
import com.example.PracticeGithub.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        String token = authService.login(req.getUsername(), req.getPassword());
        return ResponseEntity.ok(new ApiResponse<>(200, "Đăng nhập thành công", token));
    }
}
