package com.ksm.rmsofttest_ksm.member.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberDto {

    private int memberId;
    private String name;
    private LocalDateTime regDate;

}
