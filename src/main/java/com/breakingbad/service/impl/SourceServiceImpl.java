package com.breakingbad.service.impl;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.dto.DeathsDto;
import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.dto.QuotesDto;
import com.breakingbad.exception.RecordNotFoundException;
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
    public List<DeathsDto> getAllDeaths() {
        return this.mapToDeathsDtoList(deathsRepository.findAll());
    }

    @Override
    public List<EpisodesDto> getAllEpisodes() {
        return this.mapToEpisodesDtoList(episodesRepository.findAll());
    }

    @Override
    public List<QuotesDto> getAllQuotes() {
        return this.mapToQuotesDtoList(quotesRepository.findAll());
    }

    @Override
    public CharactersDto getByCharacterId(Long characterId) {
        Optional<Characters> charactersOptional = charactersRepository.findById(characterId);
        if (charactersOptional.isEmpty()) {
            throw new RecordNotFoundException("character with id: " + characterId + " does not exist");
        }
        return mapToCharactersDto(charactersOptional.get());
    }

    @Override
    public EpisodesDto getByEpisodeId(Long episodeId) {
        Optional<Episodes> episodesOptional = episodesRepository.findById(episodeId);
        if (episodesOptional.isEmpty()) {
            throw new RecordNotFoundException("episode with id: " + episodeId + " does not exist");
        }
        return mapToEpisodesDto(episodesOptional.get());
    }

    @Override
    public QuotesDto getByQuoteId(Long quoteId) {
        Optional<Quotes> quotesOptional = quotesRepository.findById(quoteId);
        if (quotesOptional.isEmpty()) {
            throw new RecordNotFoundException("quote with id: " + quoteId + " does not exist");
        }
        return mapToQuotesDto(quotesOptional.get());
    }

    private List<CharactersDto> mapToCharactersDtoList(List<Characters> data) {
        return data.stream().map(this::mapToCharactersDto).collect(Collectors.toList());
    }

    private CharactersDto mapToCharactersDto(Characters data) {
        return this.modelMapper.map(data, CharactersDto.class);
    }

    private CharactersDto getCharacterById(Long characterId) {
        Optional<Characters> charactersOptional = charactersRepository.findById(characterId);
        if (charactersOptional.isEmpty()) {
            throw new RecordNotFoundException("character with " + characterId + " does not exist");
        }
        return mapToCharactersDto(charactersOptional.get());
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
