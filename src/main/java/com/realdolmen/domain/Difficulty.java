package com.realdolmen.domain;

import lombok.Data;

@Data
public class Difficulty extends BaseEntity{
    private String difficultyName;

    public Difficulty(int id, String difficultyName) {
        super(id);
        this.difficultyName = difficultyName;
    }
}
