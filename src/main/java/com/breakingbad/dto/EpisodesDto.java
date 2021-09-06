package com.breakingbad.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EpisodesDto implements Serializable {

    private Long episodeId;
    private String title;
    private Integer season;
    private String airDate;
    private String[] characters;
    private Integer episode;
    private String series;
}
