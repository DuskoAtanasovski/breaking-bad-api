package com.breakingbad.dto;

import lombok.Data;

@Data
public class QuotesDto {

    private Long quoteId;
    private String quote;
    private String author;
    private String series;
}
