package com.breakingbad.service;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.dto.DeathsDto;
import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.dto.QuotesDto;

import java.util.List;
import java.util.Optional;

public interface SourceService {

    List<CharactersDto> getAllCharacters();

    List<DeathsDto> getAllDeaths();

    List<EpisodesDto> getAllEpisodes();

    List<QuotesDto> getAllQuotes();

    CharactersDto getByCharacterId(Long characterId);

    CharactersDto getCharacterByName(String name);

    CharactersDto getRandomCharacter();

    EpisodesDto getByEpisodeId(Long episodeId);

    EpisodesDto getRandomEpisode();

    QuotesDto getByQuoteId(Long quoteId);

    QuotesDto getRandomQuote();
}
