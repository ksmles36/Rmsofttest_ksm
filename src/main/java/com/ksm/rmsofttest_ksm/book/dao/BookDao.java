package com.ksm.rmsofttest_ksm.book.dao;

import com.ksm.rmsofttest_ksm.book.dto.BookRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public int bookRegistration(BookRegistrationDto bookRegistrationDto) {
        return sqlSessionTemplate.insert("book.bookRegistration", bookRegistrationDto);
    }


    public int bookQuantityAdd(BookRegistrationDto bookRegistrationDto) {
        return sqlSessionTemplate.update("book.bookQuantityAdd", bookRegistrationDto);
    }


    public int isExistBookName(String bookName) {
        return sqlSessionTemplate.selectOne("book.isExistBookName", bookName);
    }
}
