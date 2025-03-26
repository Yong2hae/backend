package com.yong2hae.domain.user.dto;

import com.yong2hae.domain.user.entitiy.User;

public record ProfileResponse(int age, String nickname, String email, String password) {
    public static ProfileResponse of(final User user) {
        return new ProfileResponse(user.getAge(), user.getNickname(),
                user.getEmail(), user.getPassword());
    }
}
