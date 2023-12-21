package com.ksm.rmsofttest_ksm.member.service;

import com.ksm.rmsofttest_ksm.exception.IdDuplicateException;
import com.ksm.rmsofttest_ksm.member.dao.MemberDao;
import com.ksm.rmsofttest_ksm.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDao memberDao;

    public void joinMember(MemberDto memberDto) {
        idDuplicateCheck(memberDto);

        int result = memberDao.joinMember(memberDto);

        if(result < 0)
            throw new RuntimeException("회원가입이 실패하였습니다.");
    }

    private void idDuplicateCheck(MemberDto memberDto) {
        int count = memberDao.idDuplicateCheck(memberDto.getId());
        if(count > 0)
            throw new IdDuplicateException("아이디가 중복되었습니다.");
    }

}
