package com.breakingbad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DeathsDto {

    @JsonProperty("death_id")
    private Long deathId;
    @JsonProperty("death")
    private String death;
    @JsonProperty("cause")
    private String cause;
    @JsonProperty("responsible")
    private String responsible;
    @JsonProperty("last_words")
    private String lastWords;
    @JsonProperty("season")
    private Integer season;
    @JsonProperty("episode")
    private Integer episode;
    @JsonProperty("number_of_deaths")
    private Integer numberOfDeaths;
}
