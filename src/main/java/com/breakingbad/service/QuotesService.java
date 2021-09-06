package com.breakingbad.service;

import com.breakingbad.dto.QuotesDto;

import java.util.List;
import java.util.Optional;

public interface QuotesService {

    List<QuotesDto> getAllQuotes();

    Optional<QuotesDto> getByQuoteId(Long quoteId);

    void saveQuotes();
}
