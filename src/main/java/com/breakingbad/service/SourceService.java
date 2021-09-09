package com.breakingbad.service;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.dto.DeathsDto;
import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.dto.QuotesDto;

import java.util.List;
import java.util.Optional;

public interface SourceService {

    List<CharactersDto> getAllCharacters();

    Optional<CharactersDto> getByCharacterId(Long characterId);

    List<DeathsDto> getAllDeaths();

    List<EpisodesDto> getAllEpisodes();

    Optional<EpisodesDto> getByEpisodeId(Long episodeId);

    List<QuotesDto> getAllQuotes();

    Optional<QuotesDto> getByQuoteId(Long quoteId);
}
