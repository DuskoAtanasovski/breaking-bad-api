package com.breakingbad.service.impl;

import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.model.Episodes;
import com.breakingbad.repository.EpisodesRepository;
import com.breakingbad.service.EpisodesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Override
    public List<EpisodesDto> getAllEpisodes() {
        return this.mapToEpisodesDtoList(episodesRepository.findAll());
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
                episodes.setCharacters(episodesDto.getCharacters());
                episodes.setEpisode(episodesDto.getEpisode());
                episodes.setSeries(episodesDto.getSeries());
                episodesRepository.save(episodes);
            }
        } catch (Exception e) {

        }
    }

    private List<EpisodesDto> mapToEpisodesDtoList(List<Episodes> data) {
        return data.stream().map(this::mapToEpisodesDto).collect(Collectors.toList());
    }

    private EpisodesDto mapToEpisodesDto(Episodes data) {
        return this.modelMapper.map(data, EpisodesDto.class);
    }


}
