package ru.aurakhov.mysecondtestapspringbootlr2.service;

import org.springframework.stereotype.Service;
import ru.aurakhov.mysecondtestapspringbootlr2.exception.UnsupportedCodeException;
import ru.aurakhov.mysecondtestapspringbootlr2.model.Request;
import ru.aurakhov.mysecondtestapspringbootlr2.model.Response;

@Service
public interface UnsupportedCodeService {

    void isValid(String s) throws UnsupportedCodeException;
}


