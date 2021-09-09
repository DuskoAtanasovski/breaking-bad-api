package com.breakingbad.service.impl;

import com.breakingbad.dto.QuotesDto;
import com.breakingbad.model.Quotes;
import com.breakingbad.repository.QuotesRepository;
import com.breakingbad.service.QuotesService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper modelMapper;

    @Override
    public List<QuotesDto> getAllQuotes() {
        return this.mapToQuotesDtoList(quotesRepository.findAll());
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

    private List<QuotesDto> mapToQuotesDtoList(List<Quotes> data) {
        return data.stream().map(this::mapToQuotesDto).collect(Collectors.toList());
    }

    private QuotesDto mapToQuotesDto(Quotes data) {
        return this.modelMapper.map(data, QuotesDto.class);
    }

}
