package com.breakingbad.service.impl;

import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.service.EpisodesService;

import java.util.List;
import java.util.Optional;

public class EpisodesServiceImpl implements EpisodesService {
    @Override
    public List<EpisodesDto> getAllEpisodes() {
        return null;
    }

    @Override
    public Optional<EpisodesDto> getByEpisodeId(Long episodeId) {
        return Optional.empty();
    }

    @Override
    public void saveEpisodes() {

    }
}
