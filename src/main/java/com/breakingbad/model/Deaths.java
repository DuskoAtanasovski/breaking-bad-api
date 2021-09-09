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
public class Deaths {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long deathId;
    private String death;
    private String cause;
    private String responsible;
    private String lastWords;
    private Integer season;
    private Integer episode;
    private Integer numberOfDeaths;
}
