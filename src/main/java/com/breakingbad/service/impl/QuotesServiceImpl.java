package com.breakingbad.service.impl;

import com.breakingbad.dto.QuotesDto;
import com.breakingbad.service.QuotesService;

import java.util.List;
import java.util.Optional;

public class QuotesServiceImpl implements QuotesService {
    @Override
    public List<QuotesDto> getAllQuotes() {
        return null;
    }

    @Override
    public Optional<QuotesDto> getByQuoteId(Long quoteId) {
        return Optional.empty();
    }

    @Override
    public void saveQuotes() {

    }
}
