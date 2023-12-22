package com.ksm.rmsofttest_ksm.book.controller;

import com.ksm.rmsofttest_ksm.book.dto.BookLoanReqeust;
import com.ksm.rmsofttest_ksm.book.dto.BookRegistrationRequest;
import com.ksm.rmsofttest_ksm.book.dto.BookReturnRequest;
import com.ksm.rmsofttest_ksm.book.dto.UpdateBookQuantityRequest;
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
    public ResponseEntity<ApiResponse<String>> bookRegistration(@RequestBody BookRegistrationRequest bookRegistrationRequest) {
        bookService.bookRegistration(bookRegistrationRequest);
        return new ResponseEntity<>(new ApiResponse<>(200, "Success", "도서등록이 완료되었습니다."), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/book/quantity")
    public ResponseEntity<ApiResponse<String>> updateBookQuantity(@RequestBody UpdateBookQuantityRequest updateBookQuantityRequest){
        bookService.updateBookQuantity(updateBookQuantityRequest);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", "도서 수정이 완료되었습니다."), HttpStatus.OK);
    }

    @PostMapping(value = "/book/loan")
    public ResponseEntity<ApiResponse<String>> bookLoan(@RequestBody BookLoanReqeust bookLoanReqeust) {
        bookService.bookLoan(bookLoanReqeust);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", "도서를 대출하였습니다!"), HttpStatus.OK);
    }

    @PostMapping(value = "/book/return")
    public ResponseEntity<ApiResponse<String>> bookReturn(@RequestBody BookReturnRequest bookReturnRequest) {
        bookService.bookReturn(bookReturnRequest);
        return new ResponseEntity<>(new ApiResponse<>(200, "success", "도서를 반납하였습니다!"), HttpStatus.OK);
    }



}
