package br.ufpb.dcx.lab.controller.exceptions;

import br.ufpb.dcx.lab.services.exceptions.DisciplinaNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DisciplinaNotFound.class)
    public ResponseEntity<StandardError> disciplinaNotFound(DisciplinaNotFound e, HttpServletRequest request){
        String error = "Not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}