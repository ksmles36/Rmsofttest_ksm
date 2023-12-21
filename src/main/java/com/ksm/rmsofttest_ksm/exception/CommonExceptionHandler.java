package com.ksm.rmsofttest_ksm.exception;

import com.ksm.rmsofttest_ksm.member.dto.MemberApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(IdDuplicateException.class)
    public ResponseEntity<MemberApiResponse<String>> handleIdDuplicateException(IdDuplicateException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.ok().body((new MemberApiResponse<>(901, "Fail", exception.getMessage())));
    }





}
