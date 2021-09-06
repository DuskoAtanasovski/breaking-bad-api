package com.breakingbad.dto;

import lombok.Data;

import javax.persistence.Lob;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CharactersDto implements Serializable {

    private Long characterId;
    private String name;
    private String birthday;
    private String image;
    private String nickname;
    private String portrayed;
}
