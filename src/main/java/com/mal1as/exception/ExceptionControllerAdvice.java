package com.mal1as.exception;

import com.mal1as.dto.ExtendedResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ExtendedResponseDTO> handleValidationException(RequestValidationException e) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ExtendedResponseDTO.builder()
                        .response(HttpStatus.BAD_REQUEST.getReasonPhrase() + " : " + e.getMessage())
                        .build());
    }

    @ExceptionHandler
    public ResponseEntity<ExtendedResponseDTO> handleInternalServerError(Exception e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ExtendedResponseDTO.builder()
                        .response(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() + " : " + e.getMessage())
                        .build());
    }
}