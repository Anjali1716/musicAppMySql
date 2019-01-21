package com.stackroute;

import com.stackroute.exception.EmptyFieldException;
import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotExistsException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j
public class GlobalExceptionHandler {

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Not all mandatory fields are filled-reason")
    @ExceptionHandler(EmptyFieldException.class)
    public void handleEmptyFieldException(EmptyFieldException e){
        log.error("Not all mandatory fields are filled", e);
    }

    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Track already exists-reason")
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public void handleTrackAlreadyExistsException(TrackAlreadyExistsException e){
        log.error("Track already exists", e);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Track does not exist-reason")
    @ExceptionHandler(TrackNotExistsException.class)
    public void handleTrackDoesNotExistException(TrackNotExistsException e){
        log.error("Track does not exist", e);
    }
}
