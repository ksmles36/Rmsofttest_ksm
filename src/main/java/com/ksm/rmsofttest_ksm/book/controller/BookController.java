package com.ksm.rmsofttest_ksm.book.controller;

import com.ksm.rmsofttest_ksm.book.dto.BookApiResponse;
import com.ksm.rmsofttest_ksm.book.dto.BookRegistrationDto;
import com.ksm.rmsofttest_ksm.book.dto.UpdateBookQuantityDto;
import com.ksm.rmsofttest_ksm.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping(value = "/book")
    public ResponseEntity<BookApiResponse<String>> bookRegistration(@RequestBody BookRegistrationDto bookRegistrationDto) {
        bookService.bookRegistration(bookRegistrationDto);
        return ResponseEntity.created(URI.create("http://localhost:8096/book"))
                .body((new BookApiResponse<>(200, "Success", "도서등록이 완료되었습니다.")));
    }

    @PatchMapping(value = "/book/quantity")
    public ResponseEntity<BookApiResponse<String>> updateBookQuantity(@RequestBody UpdateBookQuantityDto updateBookQuantityDto){
        return null;
    }




}
