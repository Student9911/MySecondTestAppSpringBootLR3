package ru.aurakhov.mysecondtestapspringbootlr3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.aurakhov.mysecondtestapspringbootlr3.model.Response;

import java.util.UUID;

@Slf4j
@Service
@Qualifier("ModifyOperationUidResponseService ")
public class ModifyOperationUidResponseService implements ModifyResponseService {
    @Override
    public Response modify(Response response) {

        UUID uuid = UUID.randomUUID();

        response.setOperationUid(uuid.toString());
        log.info("Класс modifyOperationUidResponseService" +
                "OperationUid присваивается рандомный ID: "+ response.getOperationUid());

        return response;
    }
}
