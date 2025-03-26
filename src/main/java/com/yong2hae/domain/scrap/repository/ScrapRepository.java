package com.yong2hae.domain.scrap.repository;

import com.yong2hae.domain.article.entitiy.Article;
import com.yong2hae.domain.scrap.dto.ScrapResponse;
import com.yong2hae.domain.scrap.entitiy.Scrap;
import com.yong2hae.domain.user.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {

    List<Scrap> findAllByUser(User user);
}
