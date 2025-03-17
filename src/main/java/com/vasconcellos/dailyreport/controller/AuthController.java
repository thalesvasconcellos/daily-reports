package com.vasconcellos.dailyreport.controller;

import com.vasconcellos.dailyreport.dto.user.UserDto;
import com.vasconcellos.dailyreport.dto.user.login.LoginDto;
import com.vasconcellos.dailyreport.dto.user.login.LoginResponseDto;
import com.vasconcellos.dailyreport.service.UserService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto data) {
        return ResponseEntity.ok(userService.login(data));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@Valid @RequestBody UserDto data) {
        return ResponseEntity.ok(userService.register(data));
    }
}