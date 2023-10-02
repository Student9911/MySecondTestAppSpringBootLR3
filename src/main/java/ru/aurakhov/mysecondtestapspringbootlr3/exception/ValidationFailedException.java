package ru.aurakhov.mysecondtestapspringbootlr2.exception;

public class ValidationFailedException extends Exception{
    public ValidationFailedException(String message) {
        super(message);
    }
}
