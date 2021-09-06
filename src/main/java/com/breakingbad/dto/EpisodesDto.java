package com.breakingbad.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EpisodesDto implements Serializable {

    private Long episodeId;
    private String title;
    private Integer season;
    private String airDate;
    private List<String> characters;
    private Integer episode;
    private String series;
}
