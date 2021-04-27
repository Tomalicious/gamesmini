package com.realdolmen.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Game extends BaseEntity{
    private String gameName;
    private String editor;
    private String author;
    private int yearEdition;
    private String age;
    private int minPlayers;
    private int maxPlayers;
    private Category category; // ManyToOne
    private String playDuration;
    private Difficulty difficulty; // ManyToOne
    private double price;
    private String image;
}
