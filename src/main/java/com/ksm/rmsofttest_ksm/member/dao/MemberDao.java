package com.ksm.rmsofttest_ksm.member.dao;

import com.ksm.rmsofttest_ksm.member.dto.MemberDto;
import com.ksm.rmsofttest_ksm.member.dto.MemberDtoTest;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public MemberDtoTest test() {
        return sqlSessionTemplate.selectOne("member.selectTest1");
    }

    public int joinMember(MemberDto memberDto) {
        return sqlSessionTemplate.insert("member.joinMember", memberDto);
    }

    public int idDuplicateCheck(String id) {
        return sqlSessionTemplate.selectOne("member.idDuplicateCheck", id);
    }
}
