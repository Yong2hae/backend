package com.yong2hae.domain.user.controller;

import com.yong2hae.domain.user.dto.ProfileResponse;
import com.yong2hae.domain.user.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/profile")
    public ResponseEntity<ProfileResponse> getMyProfile() {
        ProfileResponse response = myPageService.getMyProfile();
        return ResponseEntity.ok(response);
    }
}
