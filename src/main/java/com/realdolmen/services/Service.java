package com.realdolmen.services;

import com.realdolmen.domain.Difficulty;

import java.util.List;

public interface Service<T> {
    default T findById(int id) throws  java.lang.Exception {
        System.out.println("findById is not Implemented");
        throw new java.lang.Exception();
    }

    default List<T> findAll() throws java.lang.Exception {
        System.out.println("findAll is not Implemented");
        throw new java.lang.Exception();
    }

    default List<T> findByName(String name) throws java.lang.Exception {
        System.out.println("findByName is not Implemented");
        throw new java.lang.Exception();
    }

    default List<T> findByDifficulty(List<Difficulty> minimumDifficultyList) throws java.lang.Exception {
        System.out.println("findByDifficulty is not Implemented");
        throw new java.lang.Exception();
    }
}
