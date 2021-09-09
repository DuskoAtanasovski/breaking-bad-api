package com.breakingbad.service.impl;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.dto.DeathsDto;
import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.dto.QuotesDto;
import com.breakingbad.model.Characters;
import com.breakingbad.model.Deaths;
import com.breakingbad.model.Episodes;
import com.breakingbad.model.Quotes;
import com.breakingbad.repository.CharactersRepository;
import com.breakingbad.repository.DeathsRepository;
import com.breakingbad.repository.EpisodesRepository;
import com.breakingbad.repository.QuotesRepository;
import com.breakingbad.service.SourceService;
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
public class SourceServiceImpl implements SourceService {

    private final ModelMapper modelMapper;

    private final CharactersRepository charactersRepository;
    private final DeathsRepository deathsRepository;
    private final EpisodesRepository episodesRepository;
    private final QuotesRepository quotesRepository;

    @Override
    public List<CharactersDto> getAllCharacters() {
        return this.mapToCharactersDtoList(charactersRepository.findAll());
    }

    @Override
    public Optional<CharactersDto> getByCharacterId(Long characterId) {
        return Optional.empty();
    }

    @Override
    public List<DeathsDto> getAllDeaths() {
        return this.mapToDeathsDtoList(deathsRepository.findAll());
    }

    @Override
    public List<EpisodesDto> getAllEpisodes() {
        return this.mapToEpisodesDtoList(episodesRepository.findAll());
    }

    @Override
    public Optional<EpisodesDto> getByEpisodeId(Long episodeId) {
        return Optional.empty();
    }

    @Override
    public List<QuotesDto> getAllQuotes() {
        return this.mapToQuotesDtoList(quotesRepository.findAll());
    }

    @Override
    public Optional<QuotesDto> getByQuoteId(Long quoteId) {
        return Optional.empty();
    }

    private List<CharactersDto> mapToCharactersDtoList(List<Characters> data) {
        return data.stream().map(this::mapToCharactersDto).collect(Collectors.toList());
    }

    private CharactersDto mapToCharactersDto(Characters data) {
        return this.modelMapper.map(data, CharactersDto.class);
    }

    private List<DeathsDto> mapToDeathsDtoList(List<Deaths> data) {
        return data.stream().map(this::mapToDeathsDto).collect(Collectors.toList());
    }

    private DeathsDto mapToDeathsDto(Deaths data) {
        return this.modelMapper.map(data, DeathsDto.class);
    }

    private List<EpisodesDto> mapToEpisodesDtoList(List<Episodes> data) {
        return data.stream().map(this::mapToEpisodesDto).collect(Collectors.toList());
    }

    private EpisodesDto mapToEpisodesDto(Episodes data) {
        return this.modelMapper.map(data, EpisodesDto.class);
    }

    private List<QuotesDto> mapToQuotesDtoList(List<Quotes> data) {
        return data.stream().map(this::mapToQuotesDto).collect(Collectors.toList());
    }

    private QuotesDto mapToQuotesDto(Quotes data) {
        return this.modelMapper.map(data, QuotesDto.class);
    }
}
