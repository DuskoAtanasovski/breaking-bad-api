package com.breakingbad.controller;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.dto.DeathsDto;
import com.breakingbad.dto.EpisodesDto;
import com.breakingbad.dto.QuotesDto;
import com.breakingbad.service.SourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class SourceController {

    private final SourceService sourceService;

    @GetMapping("characters/all")
    public List<CharactersDto> getAllCharacters() {
        return sourceService.getAllCharacters();
    }

    @GetMapping("deaths/all")
    public List<DeathsDto> getAllDeaths() {
        return sourceService.getAllDeaths();
    }

    @GetMapping("episodes/all")
    public List<EpisodesDto> getAllEpisodes() {
        return sourceService.getAllEpisodes();
    }

    @GetMapping("quotes/all")
    public List<QuotesDto> getAllQuotes() {
        return sourceService.getAllQuotes();
    }

    @GetMapping("characters/{characterId}")
    public CharactersDto getCharacterById(@PathVariable Long characterId) {
        return sourceService.getByCharacterId(characterId);
    }

    @GetMapping("character/{name}")
    public CharactersDto getCharacterByName(@PathVariable String name) {
        return sourceService.getCharacterByName(name);
    }

    @GetMapping("character/random")
    public CharactersDto getRandomCharacter() {
        return sourceService.getRandomCharacter();
    }

    @GetMapping("episodes/{episodeId}")
    public EpisodesDto getEpisodeById(@PathVariable Long episodeId) {
        return sourceService.getByEpisodeId(episodeId);
    }

    @GetMapping("episode/random")
    public EpisodesDto getRandomEpisode() {
        return sourceService.getRandomEpisode();
    }

    @GetMapping("quotes/{quoteId}")
    public QuotesDto getQuoteById(@PathVariable Long quoteId) {
        return sourceService.getByQuoteId(quoteId);
    }

    @GetMapping("quote/random")
    public QuotesDto getRandomQuote() {
        return sourceService.getRandomQuote();
    }

    @GetMapping("death/random")
    public DeathsDto getRandomDeath() {
        return sourceService.getRandomDeath();
    }

}
