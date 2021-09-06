package com.breakingbad.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Characters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long characterId;
    private String name;
    private String birthday;
    private String[] occupation;
    @Lob
    private String image;
    private String nickname;
    private Integer[] appearance;
    private String portrayed;
}
