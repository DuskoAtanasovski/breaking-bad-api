package com.breakingbad.controller;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.model.Characters;
import com.breakingbad.service.CharactersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CharactersController {

    private final CharactersService charactersService;

    @GetMapping("all")
    public List<CharactersDto> getAll(){
       return charactersService.getAllCharacters();
    }

    @GetMapping("save")
    public void saveCharacters() {
        charactersService.saveCharacters();
    }
}
