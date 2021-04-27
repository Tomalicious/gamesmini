package com.realdolmen.commandpattern;

import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.services.CategoryServiceImpl;

//This is my command
public class ShowFirstGameCategory implements Command {
    private CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();

    @Override
    public void execute() throws NotFoundException {
        System.out.println("---- Result -----");
        System.out.printf("%s\n", categoryServiceImpl.findById(1));
        System.out.println("---------");

    }
}
