package com.yong2hae.domain.scrap.dto;

import com.yong2hae.domain.scrap.entitiy.Scrap;

import java.time.LocalDateTime;

public record ScrapResponse(int age, String nickname,
                            String email, String password,
                            String title, String content, LocalDateTime createdAt,
                            LocalDateTime updatedAt, String summary, String reporter,
                            String articleImg, Long views) {

    public static ScrapResponse of(final Scrap scrap) {
        return new ScrapResponse(scrap.getUser().getAge(), scrap.getUser().getNickname(),
                scrap.getUser().getEmail(), scrap.getUser().getPassword(),
                scrap.getArticle().getTitle(), scrap.getArticle().getContent(), scrap.getArticle().getCreatedAt(),
                scrap.getArticle().getUpdatedAt(), scrap.getArticle().getSummary(), scrap.getArticle().getReporter(),
                scrap.getArticle().getArticleImg(), scrap.getArticle().getViews());
    }
}
