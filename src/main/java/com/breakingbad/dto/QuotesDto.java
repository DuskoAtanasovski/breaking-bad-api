package com.breakingbad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuotesDto {

    @JsonProperty("quote_id")
    private Long quoteId;
    @JsonProperty("quote")
    private String quote;
    @JsonProperty("author")
    private String author;
    @JsonProperty("series")
    private String series;
}
