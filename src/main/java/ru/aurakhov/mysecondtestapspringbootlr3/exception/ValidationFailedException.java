package ru.aurakhov.mysecondtestapspringbootlr3.exception;

public class ValidationFailedException extends Exception{
    public ValidationFailedException(String message) {
        super(message);
    }
}
