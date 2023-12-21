package com.ksm.rmsofttest_ksm.book.controller;

import com.ksm.rmsofttest_ksm.book.dto.BookRegistrationDto;
import com.ksm.rmsofttest_ksm.book.dto.UpdateBookQuantityDto;
import com.ksm.rmsofttest_ksm.book.service.BookService;
import com.ksm.rmsofttest_ksm.global.responseDto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/book")
    public ResponseEntity<ApiResponse<String>> bookRegistration(@RequestBody BookRegistrationDto bookRegistrationDto) {
        bookService.bookRegistration(bookRegistrationDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "Success", "도서등록이 완료되었습니다."), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/book/quantity")
    public ResponseEntity<ApiResponse<String>> updateBookQuantity(@RequestBody UpdateBookQuantityDto updateBookQuantityDto){
        return null;
    }




}
