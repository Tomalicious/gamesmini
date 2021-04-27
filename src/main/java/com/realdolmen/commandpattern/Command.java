package com.realdolmen.commandpattern;

import com.realdolmen.exceptions.NotFoundException;

public interface Command {
    void execute() throws NotFoundException;
}
