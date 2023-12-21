package com.ksm.rmsofttest_ksm.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookApiResponse<T> {

    private int code;
    private String message;
    private T data;

}
