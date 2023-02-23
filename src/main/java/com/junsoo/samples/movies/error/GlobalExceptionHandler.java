package com.junsoo.samples.movies.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.junsoo.samples.movies.config.Constants.NOT_FOUND;

@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler
{

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String resourceNotFoundException(NotFoundException ex) {
        log.error("[NotFoundException] " + ex.toString(), ex);
        return NOT_FOUND;
    }
}
