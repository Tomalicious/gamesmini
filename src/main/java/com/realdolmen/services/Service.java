package com.realdolmen.services;

import com.realdolmen.domain.Difficulty;
import com.realdolmen.exceptions.NotFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public interface Service<T> {
    default T findById(int id) throws NotFoundException {
        System.out.println("findById is not Implemented");
        throw new NotImplementedException();
    }

    default List<T> findAll() throws NotFoundException {
        System.out.println("findAll is not Implemented");
        throw new NotImplementedException();
    }

    default List<T> findByName(String name) throws NotFoundException {
        System.out.println("findByName is not Implemented");
        throw new NotImplementedException();
    }

    default List<T> findByDifficulty(List<Difficulty> minimumDifficultyList) throws NotFoundException {
        System.out.println("findByDifficulty is not Implemented");
        throw new NotImplementedException();
    }
}
