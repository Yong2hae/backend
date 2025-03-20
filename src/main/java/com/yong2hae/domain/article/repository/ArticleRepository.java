package com.yong2hae.domain.article.repository;

import com.yong2hae.domain.article.entitiy.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
