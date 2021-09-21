package com.breakingbad;

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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) throws RuntimeException {
        saveCharacters();
        saveDeaths();
        saveEpisodes();
        saveQuotes();
        log.info("successfully saved in db");
    }

    private final ObjectMapper objectMapper;

    private final CharactersRepository charactersRepository;
    private final DeathsRepository deathsRepository;
    private final EpisodesRepository episodesRepository;
    private final QuotesRepository quotesRepository;


    // saving characters json data to db
    private void saveCharacters() {
        try {
            List<CharactersDto> charactersDtoList = objectMapper.readValue(new URL("https://www.breakingbadapi.com/api/characters"), new TypeReference<List<CharactersDto>>() {
            });
            for (CharactersDto charactersDto : charactersDtoList) {
                Characters characters = new Characters();
                characters.setCharacterId(charactersDto.getCharacterId());
                characters.setName(charactersDto.getName());
                characters.setBirthday(charactersDto.getBirthday());
                characters.setOccupation(charactersDto.getOccupation());
                characters.setImage(charactersDto.getImage());
                characters.setNickname(charactersDto.getNickname());
                characters.setAppearance(charactersDto.getAppearance());
                characters.setPortrayed(charactersDto.getPortrayed());
                charactersRepository.save(characters);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // saving deaths json data to db
    private void saveDeaths() {
        try {
            List<DeathsDto> deathsDtoList = objectMapper.readValue(new URL("https://www.breakingbadapi.com/api/deaths"), new TypeReference<List<DeathsDto>>() {
            });
            for (DeathsDto deathsDto : deathsDtoList) {
                Deaths deaths = new Deaths();
                deaths.setDeathId(deathsDto.getDeathId());
                deaths.setDeath(deathsDto.getDeath());
                deaths.setCause(deathsDto.getCause());
                deaths.setResponsible(deathsDto.getResponsible());
                deaths.setLastWords(deathsDto.getLastWords());
                deaths.setSeason(deathsDto.getSeason());
                deaths.setEpisode(deathsDto.getEpisode());
                deaths.setNumberOfDeaths(deathsDto.getNumberOfDeaths());
                deathsRepository.save(deaths);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // saving episodes json data to db
    private void saveEpisodes() {
        try {
            List<EpisodesDto> episodesDtoList = objectMapper.readValue(new URL("https://www.breakingbadapi.com/api/episodes"), new TypeReference<List<EpisodesDto>>() {
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
            throw new RuntimeException(e);
        }
    }

    // saving quotes json data to db
    private void saveQuotes() {
        try {
            List<QuotesDto> quotesDtoList = objectMapper.readValue(new URL("https://www.breakingbadapi.com/api/quotes"), new TypeReference<List<QuotesDto>>() {
            });
            for (QuotesDto quotesDto : quotesDtoList) {
                Quotes quotes = new Quotes();
                quotes.setQuoteId(quotesDto.getQuoteId());
                quotes.setQuote(quotesDto.getQuote());
                quotes.setAuthor(quotesDto.getAuthor());
                quotes.setSeries(quotesDto.getSeries());
                quotesRepository.save(quotes);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

