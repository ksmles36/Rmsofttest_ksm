package com.ksm.rmsofttest_ksm.book.dto;

import lombok.Getter;

@Getter
public class AddBookLoanHistoryDto {

    private String historyType;
    private int memberId;
    private int bookId;

    private AddBookLoanHistoryDto(String historyType, int memberId, int bookId) {
        this.historyType = historyType;
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public static AddBookLoanHistoryDto of(String bookLoanHistoryType, int memberId, int bookId) {
        return new AddBookLoanHistoryDto(bookLoanHistoryType, memberId, bookId);
    }
}
