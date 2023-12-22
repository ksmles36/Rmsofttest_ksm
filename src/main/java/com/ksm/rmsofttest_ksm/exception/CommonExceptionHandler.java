package com.ksm.rmsofttest_ksm.exception;

import com.ksm.rmsofttest_ksm.global.responseDto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(IdDuplicateException.class)
    public ResponseEntity<ApiResponse<String>> handleIdDuplicateException(IdDuplicateException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(601, "Id duplicated", exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(JoinMemberException.class)
    public ResponseEntity<ApiResponse<String>> handleJoinMemberException(JoinMemberException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(602, "Join member fail", exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(SqlExecuteFailException.class)
    public ResponseEntity<ApiResponse<String>> handleSqlExecuteException(SqlExecuteFailException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(605, "Sql execute fail", exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<String>> handleNoSuchElementException(NoSuchElementException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(604, "Request fail", exception.getMessage()), HttpStatus.OK);
    }



}
