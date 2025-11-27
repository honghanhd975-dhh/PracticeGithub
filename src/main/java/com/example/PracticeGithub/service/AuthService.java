package com.example.PracticeGithub.service;


import com.example.PracticeGithub.repository.AccountRepository;
import com.example.PracticeGithub.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(String username, String password) {
        var acc = accountRepository.findByUsernameAndPassword(username, password);

        if (acc.isEmpty()) {
            throw new RuntimeException("Sai tài khoản hoặc mật khẩu");
        }

        return jwtUtil.generateToken(username);
    }
}