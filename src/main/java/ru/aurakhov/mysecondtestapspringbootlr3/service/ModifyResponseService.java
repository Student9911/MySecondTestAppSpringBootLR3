package ru.aurakhov.mysecondtestapspringbootlr3.service;

import org.springframework.stereotype.Service;
import ru.aurakhov.mysecondtestapspringbootlr3.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);



}

