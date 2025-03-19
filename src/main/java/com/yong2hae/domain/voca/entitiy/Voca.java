package com.yong2hae.domain.voca.entitiy;

import com.yong2hae.domain.article.entitiy.Article;
import com.yong2hae.domain.user.entitiy.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Voca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vocaId;

    private String word;

    private String meaning;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne  //fetch = Lazy로 수정 예정
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne // 수정 예정
    @JoinColumn(name = "article_id")
    private Article article;
}
