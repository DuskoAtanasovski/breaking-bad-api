package com.breakingbad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EpisodesDto implements Serializable {

    @JsonProperty("episode_id")
    private Long episodeId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("season")
    private Integer season;
    @JsonProperty("air_date")
    private String airDate;
    @JsonProperty("characters")
    private String[] characters;
    @JsonProperty("episode")
    private Integer episode;
    @JsonProperty("series")
    private String series;
}
