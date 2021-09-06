package com.breakingbad.service;

import com.breakingbad.dto.CharactersDto;

import java.util.List;
import java.util.Optional;

public interface CharactersService {

    List<CharactersDto> getAllCharacters();

    Optional<CharactersDto> getByCharacterId(Long characterId);

    void saveCharacters();

}
