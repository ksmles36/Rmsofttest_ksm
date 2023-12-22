package com.ksm.rmsofttest_ksm.book.type;

public enum BookLoanHistoryType {

    BOOK_LOAN("L", "도서대출"),
    BOOK_RETURN("R", "도서반납")
    ;

    public final String code;
    public final String description;

    BookLoanHistoryType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
