package com.breakingbad.service.impl;

import com.breakingbad.dto.DeathsDto;
import com.breakingbad.model.Deaths;
import com.breakingbad.repository.DeathsRepository;
import com.breakingbad.service.DeathsService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeathsServiceImpl implements DeathsService {

    private final DeathsRepository deathsRepository;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Override
    public List<DeathsDto> getAllDeaths() {
        List<Deaths> deathsList = deathsRepository.findAll();
        return deathsList.stream().map(this::mapFromDeathsToDto).collect(Collectors.toList());
    }

    @Override
    public void saveDeaths() {
        try {
            List<DeathsDto> deathsDtoList = objectMapper.readValue(resourceLoader.getResource("classpath:sources/deaths.json").getInputStream(), new TypeReference<List<DeathsDto>>() {
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

        }
    }

    private DeathsDto mapFromDeathsToDto(Deaths deaths) {
        DeathsDto deathsDto = new DeathsDto();
        deathsDto.setDeathId(deaths.getDeathId());
        deathsDto.setDeath(deaths.getDeath());
        deathsDto.setCause(deaths.getCause());
        deathsDto.setResponsible(deaths.getResponsible());
        deathsDto.setLastWords(deaths.getLastWords());
        deathsDto.setSeason(deaths.getSeason());
        deathsDto.setEpisode(deaths.getEpisode());
        deathsDto.setNumberOfDeaths(deaths.getNumberOfDeaths());


        return deathsDto;
    }
}
