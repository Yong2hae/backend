package com.yong2hae.domain.user.controller;

import com.yong2hae.domain.user.dto;
import com.yong2hae.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String signup(@RequestBody UserDTO userDTO) {
        return userService.signup(userDTO);
    }

    @GetMapping("/email-check")
    public boolean checkEmail(@RequestParam String email) {
        return userService.checkEmailDuplicate(email);
    }

    @GetMapping("/{nickname}/check")
    public boolean checkNickname(@PathVariable String nickname) {
        return userService.checkNicknameDuplicate(nickname);
    }

    @PostMapping("/local-login")
    public String login(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

    @PostMapping("/social-login")
    public String socialLogin(@RequestBody UserDTO userDTO) {
        return userService.socialLogin(userDTO);
    }

    @PostMapping("/onboarding")
    public String onboarding(@RequestBody UserDTO userDTO) {
        return userService.onboarding(userDTO);
    }
}
