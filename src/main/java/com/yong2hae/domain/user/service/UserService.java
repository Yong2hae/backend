package com.yong2hae.domain.user.service;

import com.yong2hae.domain.user.entitiy.User;
import com.yong2hae.domain.user.repository.UserRepository;
import com.yong2hae.global.exception.CustomException;
import com.yong2hae.global.exception.ExceptionContent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findUserById(final Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ExceptionContent.NOT_FOUND_USER));
    }
}
