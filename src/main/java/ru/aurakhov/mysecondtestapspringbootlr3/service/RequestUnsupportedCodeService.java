package ru.aurakhov.mysecondtestapspringbootlr2.service;

import org.springframework.stereotype.Service;
import ru.aurakhov.mysecondtestapspringbootlr2.exception.UnsupportedCodeException;

@Service
public class RequestUnsupportedCodeService implements UnsupportedCodeService {
    @Override
    public void isValid(String s) throws UnsupportedCodeException {
        if (s.equals("123")) {
            throw new UnsupportedCodeException("Uid не должен быть '123'");
        }
    }
}
