package ru.aurakhov.mysecondtestapspringbootlr2.exception;

public class UnsupportedCodeException extends Exception{
    // Конструктор с сообщением об ошибке
    public UnsupportedCodeException(String message) {
        super(message);
    }
}
