package com.breakingbad.controller;

import com.breakingbad.dto.CharactersDto;
import com.breakingbad.service.CharactersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CharactersController {

    private final CharactersService charactersService;

    @GetMapping("characters/all")
    public List<CharactersDto> getAllCharacters() {
        return charactersService.getAllCharacters();
    }

    @GetMapping("characters/save")
    public ResponseEntity saveCharacters() {
        charactersService.saveCharacters();
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
