package com.doge.blog.controller;

import com.doge.blog.exception.BaseException;
import com.doge.blog.utils.SuccessOrFailResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Meddkim on 2017/9/23.
 */
@Slf4j
@RestControllerAdvice
public class ExceptionRestController {

    @ExceptionHandler(BaseException.class)
    @ResponseStatus(value = HttpStatus.OK)
    public Object handleBaseException(BaseException e){
        log.info("");
        return new SuccessOrFailResp(e.getCode(),e.getMessage());
    }
}
