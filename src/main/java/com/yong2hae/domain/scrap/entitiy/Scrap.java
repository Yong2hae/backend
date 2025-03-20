package com.yong2hae.domain.scrap.entitiy;

import com.yong2hae.domain.article.entitiy.Article;
import com.yong2hae.domain.user.entitiy.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Scrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrapId;

    @ManyToOne // fetch lazy 수정 예정
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne // 수정 예정
    @JoinColumn(name = "article_id")
    private Article article;

    public static Scrap of(User user, Article article) {
        return builder()
                .user(user)
                .article(article)
                .build();
    }

}
