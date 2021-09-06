package com.breakingbad.controller;

import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.service.EpisodesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class EpisodesController {

    private final EpisodesService episodesService;

    @GetMapping("episodes/all")
    public List<EpisodesDto> getAll() {
        return episodesService.getAllEpisodes();
    }

    @GetMapping("episodes/save")
    public void saveEpisodes() {
        episodesService.saveEpisodes();
    }
}
