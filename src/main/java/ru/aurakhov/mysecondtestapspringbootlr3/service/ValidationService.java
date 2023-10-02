package ru.aurakhov.mysecondtestapspringbootlr3.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.aurakhov.mysecondtestapspringbootlr3.exception.ValidationFailedException;

@Service
public interface ValidationService {

    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
