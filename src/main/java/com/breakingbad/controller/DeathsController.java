package com.breakingbad.controller;

import com.breakingbad.dto.DeathsDto;
import com.breakingbad.service.DeathsService;
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
public class DeathsController {

    private final DeathsService deathsService;

    @GetMapping("deaths/all")
    public List<DeathsDto> getAll() {
        return deathsService.getAllDeaths();
    }

    @GetMapping("deaths/save")
    public ResponseEntity saveDeaths() {
        deathsService.saveDeaths();
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
