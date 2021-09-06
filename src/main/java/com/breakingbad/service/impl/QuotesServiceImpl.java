package com.breakingbad.service.impl;

import com.breakingbad.dto.QuotesDto;
import com.breakingbad.model.Quotes;
import com.breakingbad.repository.QuotesRepository;
import com.breakingbad.service.QuotesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuotesServiceImpl implements QuotesService {

    private final QuotesRepository quotesRepository;
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;

    @Override
    public List<QuotesDto> getAllQuotes() {
        List<Quotes> quotesList = quotesRepository.findAll();
        return quotesList.stream().map(this::mapFromQuotesToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<QuotesDto> getByQuoteId(Long quoteId) {
        return Optional.empty();
    }

    @Override
    public void saveQuotes() {
        try {
            List<QuotesDto> quotesDtoList = objectMapper.readValue(resourceLoader.getResource("classpath:sources/quotes.json").getInputStream(), new TypeReference<List<QuotesDto>>() {
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

        }
    }

    private QuotesDto mapFromQuotesToDto(Quotes quotes) {
        QuotesDto quotesDto = new QuotesDto();
        quotesDto.setQuoteId(quotes.getQuoteId());
        quotesDto.setQuote(quotes.getQuote());
        quotesDto.setAuthor(quotes.getAuthor());
        quotesDto.setSeries(quotes.getSeries());

        return quotesDto;
    }
}
