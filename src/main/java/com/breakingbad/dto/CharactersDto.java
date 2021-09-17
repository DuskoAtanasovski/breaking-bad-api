package com.breakingbad.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CharactersDto {

    @JsonProperty("char_id")
    private Long characterId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("birthday")
    private String birthday;
    @JsonProperty("occupation")
    private String[] occupation;
    @JsonProperty("img")
    private String image;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("appearance")
    private Integer[] appearance;
    @JsonProperty("portrayed")
    private String portrayed;
}
