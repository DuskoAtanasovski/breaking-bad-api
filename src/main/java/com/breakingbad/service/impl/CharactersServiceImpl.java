package com.breakingbad.service.impl;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.model.Characters;
import com.breakingbad.repository.CharactersRepository;
import com.breakingbad.service.CharactersService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharactersServiceImpl implements CharactersService {

    private final CharactersRepository charactersRepository;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    private final ModelMapper modelMapper;

    @Override
    public List<CharactersDto> getAllCharacters() {
        return this.mapToCharactersDtoList(charactersRepository.findAll());
    }

    @Override
    public Optional<CharactersDto> getByCharacterId(Long characterId) {
        return Optional.empty();
    }

    @Override
    public void saveCharacters() {
        try {
            List<CharactersDto> charactersDtoList = objectMapper.readValue(resourceLoader.getResource("classpath:sources/characters.json").getInputStream(), new TypeReference<List<CharactersDto>>() {
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

    private List<CharactersDto> mapToCharactersDtoList(List<Characters> data) {
        return data.stream().map(this::mapToCharactersDto).collect(Collectors.toList());
    }

    private CharactersDto mapToCharactersDto(Characters data) {
        return this.modelMapper.map(data, CharactersDto.class);
    }

}
