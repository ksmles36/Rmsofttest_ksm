package com.ksm.rmsofttest_ksm.member.controller;

import com.ksm.rmsofttest_ksm.member.dao.MemberDao;
import com.ksm.rmsofttest_ksm.member.dto.MemberDto;
import com.ksm.rmsofttest_ksm.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;
    private final MemberDao memberDao;

    @GetMapping(value = "/test")
    public ResponseEntity<MemberDto> test(){
        MemberDto memberDto = memberDao.test();
        return ResponseEntity.ok().body(memberDto);
    }



}
