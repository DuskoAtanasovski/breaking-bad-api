package com.breakingbad.controller;

import com.breakingbad.dto.QuotesDto;
import com.breakingbad.service.QuotesService;
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
public class QuotesController {

    private final QuotesService quotesService;

    @GetMapping("quotes/all")
    public List<QuotesDto> getAll() {
        return quotesService.getAllQuotes();
    }

    @GetMapping("quotes/save")
    public ResponseEntity saveQuotes() {
        quotesService.saveQuotes();
        return new ResponseEntity("Success", HttpStatus.OK);
    }
}
