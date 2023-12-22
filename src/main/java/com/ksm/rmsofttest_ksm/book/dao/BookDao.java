package com.ksm.rmsofttest_ksm.book.dao;

import com.ksm.rmsofttest_ksm.book.dto.*;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookDao {

    private final SqlSessionTemplate sqlSessionTemplate;

    public int bookRegistration(BookRegistrationRequest bookRegistrationRequest) {
        return sqlSessionTemplate.insert("book.bookRegistration", bookRegistrationRequest);
    }


    public int bookQuantityAdd(BookRegistrationRequest bookRegistrationRequest) {
        return sqlSessionTemplate.update("book.bookQuantityAdd", bookRegistrationRequest);
    }


    public int isExistBookName(String bookName) {
        return sqlSessionTemplate.selectOne("book.isExistBookName", bookName);
    }

    public int updateBookQuantity(UpdateBookQuantityRequest updateBookQuantityRequest) {
        return sqlSessionTemplate.update("book.updateBookQuantity", updateBookQuantityRequest);
    }

    public int getBookLoanableQuantity(BookLoanDto bookLoanDto) {
        return sqlSessionTemplate.selectOne("book.getBookLoanableQuantity", bookLoanDto);
    }

    public int addBooksOnLoan(BookLoanDto bookLoanDto) {
        return sqlSessionTemplate.insert("book.addBooksOnLoan", bookLoanDto);
    }

    public int addBookLoanHistory(AddBookLoanHistoryDto addBookLoanHistoryDto) {
        return sqlSessionTemplate.insert("book.addBookLoanHistory", addBookLoanHistoryDto);
    }

    public int getBookIdByBookName(String bookName) {
        return sqlSessionTemplate.selectOne("book.getBookIdByBookName", bookName);
    }

    public int deductLoanableQuantity(BookLoanDto bookLoanDto) {
        return sqlSessionTemplate.update("book.deductLoanableQuantity", bookLoanDto);
    }

    public int getBooksOnLoan(BookLoanDto bookLoanDto) {
        return sqlSessionTemplate.selectOne("book.getBooksOnLoan", bookLoanDto);
    }

    public int deleteBooksOnLoan(BookLoanDto bookLoanDto) {
        return sqlSessionTemplate.delete("book.deleteBooksOnLoan", bookLoanDto);
    }

    public int addLoanableQuantity(BookLoanDto bookLoanDto) {
        return sqlSessionTemplate.update("book.addLoanableQuantity", bookLoanDto);
    }

    public List<BookLoanHistoryResponse> getBookLoanHistory(int memberId) {
        return sqlSessionTemplate.selectList("book.getBookLoanHistory", memberId);
    }
}
