package com.realdolmen.services;

import com.realdolmen.domain.Category;
import com.realdolmen.repositories.CategoryRepository;

public class CategoryServiceImpl implements Service<Category>{

    private final CategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public Category findById(int id) throws Exception {
        return categoryRepository.findById(id);
    }

}
