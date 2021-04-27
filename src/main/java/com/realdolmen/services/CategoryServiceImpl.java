package com.realdolmen.services;

import com.realdolmen.domain.Category;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.repositories.CategoryRepository;

public class CategoryServiceImpl implements Service<Category>{

    private final CategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public Category findById(int id) throws NotFoundException {
        return categoryRepository.findById(id);
    }

}
