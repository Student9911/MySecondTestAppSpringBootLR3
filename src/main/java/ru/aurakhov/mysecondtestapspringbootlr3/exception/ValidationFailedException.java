package ru.aurakhov.mysecondtestapspringbootlr3.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationFailedException extends Exception{
    public ValidationFailedException(String message) {
        super(message);
        log.warn(message);


    }
}
