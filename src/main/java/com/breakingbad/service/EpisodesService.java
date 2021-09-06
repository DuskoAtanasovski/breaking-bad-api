package com.breakingbad.service;

import com.breakingbad.dto.EpisodesDto;

import java.util.List;
import java.util.Optional;

public interface EpisodesService {

    List<EpisodesDto> getAllEpisodes();

    Optional<EpisodesDto> getByEpisodeId(Long episodeId);

    void saveEpisodes();
}
