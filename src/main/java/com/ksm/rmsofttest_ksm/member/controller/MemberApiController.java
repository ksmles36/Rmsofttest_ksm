package com.ksm.rmsofttest_ksm.member.controller;

import com.ksm.rmsofttest_ksm.global.responseDto.ApiResponse;
import com.ksm.rmsofttest_ksm.member.dto.MemberDto;
import com.ksm.rmsofttest_ksm.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping(value = "/member")
    public ResponseEntity<ApiResponse<String>> joinMember(@RequestBody MemberDto memberDto){
        memberService.joinMember(memberDto);
        return new ResponseEntity<>(new ApiResponse<>(200, "Success", "회원가입이 완료되었습니다."), HttpStatus.CREATED);
    }

}
