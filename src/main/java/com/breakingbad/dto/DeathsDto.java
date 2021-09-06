package com.breakingbad.dto;

import lombok.Data;

@Data
public class DeathsDto {

    private Long deathId;
    private String death;
    private String cause;
    private String responsible;
    private String lastWords;
    private Integer season;
    private Integer episode;
    private Integer numberOfDeaths;
}
