package com.breakingbad.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CharactersDto implements Serializable {

    private Long characterId;
    private String name;
    private String birthday;
    private String[] occupation;
    private String image;
    private String nickname;
    private Integer[] appearance;
    private String portrayed;
}
