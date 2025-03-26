package com.yong2hae.domain.article.service;

import com.yong2hae.domain.article.dto.ArticleDetailResponseDTO;
import com.yong2hae.domain.article.dto.ArticleResponseDTO;
import com.yong2hae.domain.article.entitiy.Article;
import com.yong2hae.domain.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    //article 전체 조회
    public List<ArticleResponseDTO> getAllArticles(){
        List<Article> articles = articleRepository.findAll();

        List<ArticleResponseDTO> articlesDTO = articles.stream()
                .map(ArticleResponseDTO::of)
                .toList();

        return articlesDTO;
    }

    //article 상세 조회
    public ArticleDetailResponseDTO getArticleById(Long articleId) {
        // articleId로 Article을 찾기
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + articleId));
        // 찾은 Article을 DTO로 변환해서 반환
        return ArticleDetailResponseDTO.of(article);
    }

    //article 삭제
    //리턴값 없어도 되는지? 삭제 확인 해야할거같은데...?
    public void deleteArticleById(Long articleId) {
        // articleId로 Article을 삭제
        articleRepository.deleteById(articleId);
    }
}