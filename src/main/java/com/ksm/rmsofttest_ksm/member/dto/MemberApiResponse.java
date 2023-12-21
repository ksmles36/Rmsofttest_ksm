package com.ksm.rmsofttest_ksm.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberApiResponse<T> {

    private int code;
    private String message;
    private T data;

}
