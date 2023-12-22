package com.ksm.rmsofttest_ksm.book.dto;

import lombok.Getter;

@Getter
public class UpdateBookQuantityDto {

    private String bookName;
    private int totalQuantity;
    private int loanableQuantity;

}
