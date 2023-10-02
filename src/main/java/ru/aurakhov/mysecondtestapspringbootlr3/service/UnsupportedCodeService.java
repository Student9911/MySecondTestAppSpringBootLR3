package ru.aurakhov.mysecondtestapspringbootlr3.service;

import org.springframework.stereotype.Service;
import ru.aurakhov.mysecondtestapspringbootlr3.exception.UnsupportedCodeException;
import ru.aurakhov.mysecondtestapspringbootlr3.model.Request;
import ru.aurakhov.mysecondtestapspringbootlr3.model.Response;

@Service
public interface UnsupportedCodeService {

    void isValid(String s) throws UnsupportedCodeException;
}


