package ru.aurakhov.mysecondtestapspringbootlr3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.aurakhov.mysecondtestapspringbootlr3.exception.UnsupportedCodeException;
import ru.aurakhov.mysecondtestapspringbootlr3.exception.ValidationFailedException;
import ru.aurakhov.mysecondtestapspringbootlr3.model.*;
import ru.aurakhov.mysecondtestapspringbootlr3.service.ModifyResponseService;
import ru.aurakhov.mysecondtestapspringbootlr3.service.UnsupportedCodeService;
import ru.aurakhov.mysecondtestapspringbootlr3.service.ValidationService;
import ru.aurakhov.mysecondtestapspringbootlr3.util.DateTimeUtil;

import javax.validation.Valid;
import java.util.Date;

@RestController
public class MyController {

    private final ValidationService validationService;
    private final UnsupportedCodeService unsupportedCodeService;

    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationService validationService, UnsupportedCodeService unsupportedCodeService, ModifyResponseService modifyResponseService) {
        this.validationService = validationService;

        this.unsupportedCodeService = unsupportedCodeService;
        this.modifyResponseService = modifyResponseService;
    }


    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {


        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        try {
            unsupportedCodeService.isValid(request.getUid());
        } catch (UnsupportedCodeException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNSUPPORTED);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            validationService.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        modifyResponseService.modify(response);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
