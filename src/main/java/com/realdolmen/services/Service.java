package com.realdolmen.services;

import com.realdolmen.domain.Difficulty;

import java.util.List;

public interface Service<T> {
    default T findById(int id) throws  Exception {
        System.out.println("findById is not Implemented");
        throw new Exception();
    }

    default List<T> findAll() throws Exception {
        System.out.println("findAll is not Implemented");
        throw new Exception();
    }

    default List<T> findByName(String name) throws Exception {
        System.out.println("findByName is not Implemented");
        throw new Exception();
    }

    default List<T> findByDifficulty(List<Difficulty> minimumDifficultyList) throws Exception {
        System.out.println("findByDifficulty is not Implemented");
        throw new Exception();
    }
}
