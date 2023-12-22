package com.ksm.rmsofttest_ksm.exception;

import com.ksm.rmsofttest_ksm.global.responseDto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(IdDuplicateException.class)
    public ResponseEntity<ApiResponse<String>> handleIdDuplicateException(IdDuplicateException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(601, "Id Duplicated", exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(JoinMemberException.class)
    public ResponseEntity<ApiResponse<String>> handleJoinMemberException(JoinMemberException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(603, "Join Member Fail", exception.getMessage()), HttpStatus.OK);
    }

    @ExceptionHandler(SqlExecuteFailException.class)
    public ResponseEntity<ApiResponse<String>> handleSqlExecuteException(SqlExecuteFailException exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(new ApiResponse<>(603, "Join Member Fail", exception.getMessage()), HttpStatus.OK);
    }

}
