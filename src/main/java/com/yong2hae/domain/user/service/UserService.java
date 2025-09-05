package com.yong2hae.domain.user.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String signup(UserDTO userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return "Username already exists!";
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(user);

        return "User registered successfully!";
    }

    public boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean checkNicknameDuplicate(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    public String login(UserDTO userDTO) {
        return userRepository.findByEmail(userDTO.getEmail())
                .filter(user -> passwordEncoder.matches(userDTO.getPassword(), user.getPassword()))
                .map(user -> "Login successful!")
                .orElse("Invalid email or password.");
    }

    public String socialLogin(UserDTO userDTO) {
        return userRepository.findByEmail(userDTO.getEmail())
                .map(user -> "Social login successful!")
                .orElseGet(() -> {
                    // 자동 회원가입
                    User newUser = new User();
                    newUser.setEmail(userDTO.getEmail());
                    newUser.setNickname(userDTO.getNickname());
                    newUser.setSocialType(userDTO.getSocialType());
                    userRepository.save(newUser);
                    return "Social login & register success!";
                });
    }

    public String onboarding(UserDTO userDTO) {
        // 온보딩 데이터 저장 로직은 추후 정의
        return "Onboarding completed!";
    }
}
