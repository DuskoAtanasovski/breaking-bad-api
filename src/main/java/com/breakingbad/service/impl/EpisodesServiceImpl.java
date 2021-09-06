package com.breakingbad.service.impl;

import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.model.Episodes;
import com.breakingbad.repository.EpisodesRepository;
import com.breakingbad.service.EpisodesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpisodesServiceImpl implements EpisodesService {

    private final EpisodesRepository episodesRepository;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Override
    public List<EpisodesDto> getAllEpisodes() {
        List<Episodes> episodesList = episodesRepository.findAll();
        return episodesList.stream().map(this::mapFromEpisodesToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<EpisodesDto> getByEpisodeId(Long episodeId) {
        return Optional.empty();
    }

    @Override
    public void saveEpisodes() {
        try {
            List<EpisodesDto> episodesDtoList = objectMapper.readValue(resourceLoader.getResource("classpath:sources/episodes.json").getInputStream(), new TypeReference<List<EpisodesDto>>() {
            });
            for (EpisodesDto episodesDto : episodesDtoList) {
                Episodes episodes = new Episodes();
                episodes.setEpisodeId(episodesDto.getEpisodeId());
                episodes.setTitle(episodesDto.getTitle());
                episodes.setSeason(episodesDto.getSeason());
                episodes.setAirDate(episodesDto.getAirDate());
                episodes.setEpisode(episodesDto.getEpisode());
                episodes.setSeries(episodesDto.getSeries());
                episodesRepository.save(episodes);
            }
        } catch (Exception e) {

        }
    }

    private EpisodesDto mapFromEpisodesToDto(Episodes episodes) {
        EpisodesDto episodesDto = new EpisodesDto();
        episodesDto.setEpisodeId(episodes.getEpisodeId());
        episodesDto.setTitle(episodes.getTitle());
        episodesDto.setSeason(episodes.getSeason());
        episodesDto.setAirDate(episodes.getAirDate());
        episodesDto.setEpisode(episodes.getEpisode());
        episodesDto.setSeries(episodes.getSeries());

        return episodesDto;
    }
}
