package com.ksm.rmsofttest_ksm.member.dao;

import com.ksm.rmsofttest_ksm.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public MemberDto test() {
        return sqlSessionTemplate.selectOne("member.selectTest1");
    }

}
