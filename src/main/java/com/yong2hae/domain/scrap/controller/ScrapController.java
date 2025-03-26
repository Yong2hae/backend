package com.yong2hae.domain.scrap.controller;

import com.yong2hae.domain.scrap.dto.ScrapResponse;
import com.yong2hae.domain.scrap.service.ScrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("scrap")
public class ScrapController {

    private final ScrapService scrapService;

    @GetMapping
    public ResponseEntity<List<ScrapResponse>> getMyScraps() {
        List<ScrapResponse> response = scrapService.getMyScraps();
        return ResponseEntity.ok(response);
    }
}
