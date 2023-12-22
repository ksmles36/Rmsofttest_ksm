package com.ksm.rmsofttest_ksm.book.dto;

import lombok.Getter;

@Getter
public class UpdateBookQuantityRequest {

    private String bookName;
    private int totalQuantity;
    private int loanableQuantity;

}
