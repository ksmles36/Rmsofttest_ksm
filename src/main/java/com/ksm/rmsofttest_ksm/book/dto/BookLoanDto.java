package com.ksm.rmsofttest_ksm.book.dto;

import lombok.Getter;

@Getter
public class BookLoanDto {

    private int memberId;
    private int bookId;

    private BookLoanDto(int memberId, int bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public static BookLoanDto of(int memberId, int bookId) {
        return new BookLoanDto(memberId, bookId);
    }

}
