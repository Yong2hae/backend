package com.yong2hae.domain.user.service;

import com.yong2hae.domain.user.dto.ProfileResponse;
import com.yong2hae.domain.user.entitiy.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MyPageService {

    private final UserService userService;

    public ProfileResponse getMyProfile() {
        Long userId = 1L; // dummy Id
        User user = userService.findUserById(userId);
        return ProfileResponse.of(user);
    }

}
