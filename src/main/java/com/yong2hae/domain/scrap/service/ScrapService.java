package com.yong2hae.domain.scrap.service;

import com.yong2hae.domain.scrap.dto.ScrapResponse;
import com.yong2hae.domain.scrap.entitiy.Scrap;
import com.yong2hae.domain.scrap.repository.ScrapRepository;
import com.yong2hae.domain.user.entitiy.User;
import com.yong2hae.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScrapService {

    private final ScrapRepository scrapRepository;
    private final UserService userService;

    public List<ScrapResponse> getMyScraps() {
        Long userId = 1L;
        User user = userService.findUserById(userId);
        List<Scrap> scraps = scrapRepository.findAllByUser(user);
        List<ScrapResponse> myScraps = scraps.stream()
                .map(ScrapResponse::of)
                .toList();

        return myScraps;
    }
}
