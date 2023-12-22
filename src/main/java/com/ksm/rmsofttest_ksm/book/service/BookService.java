package com.ksm.rmsofttest_ksm.book.service;

import com.ksm.rmsofttest_ksm.book.dao.BookDao;
import com.ksm.rmsofttest_ksm.book.dto.*;
import com.ksm.rmsofttest_ksm.book.type.BookLoanHistoryType;
import com.ksm.rmsofttest_ksm.exception.SqlExecuteFailException;
import com.ksm.rmsofttest_ksm.member.dao.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;
    private final MemberDao memberDao;

    public void bookRegistration(BookRegistrationRequest bookRegistrationRequest) {
        if(isExistBookName(bookRegistrationRequest.getBookName())){
            addBookQuantity(bookRegistrationRequest);
            return;
        }
        newBookRegistration(bookRegistrationRequest);
    }

    private void newBookRegistration(BookRegistrationRequest bookRegistrationRequest) {
        int result = bookDao.bookRegistration(bookRegistrationRequest);
        if(result < 0)
            throw new SqlExecuteFailException("신규 도서 등록에 실패하였습니다.");
    }

    private void addBookQuantity(BookRegistrationRequest bookRegistrationRequest) {
        int result = bookDao.bookQuantityAdd(bookRegistrationRequest);
        if(result < 0)
            throw new SqlExecuteFailException("도서 수량 증가에 실패하였습니다.");
    }

    private boolean isExistBookName(String bookName) {
        int count = bookDao.isExistBookName(bookName);
        if(count > 0)
            return true;
        return false;
    }

    public void updateBookQuantity(UpdateBookQuantityRequest updateBookQuantityRequest) {
        int count = bookDao.updateBookQuantity(updateBookQuantityRequest);
        if(count < 0)
            throw new SqlExecuteFailException("도서 수량 수정에 실패하였습니다.");
    }

    @Transactional
    public void bookLoan(BookLoanReqeust bookLoanReqeust) {
        BookLoanDto bookLoanDto = getBookLoanDto(bookLoanReqeust);

        loanPossibleCheck(bookLoanDto);
        addBooksOnLoan(bookLoanDto);
        deductLoanableQuantity(bookLoanDto);
        addBookLoanHistory(bookLoanDto);
    }

    private BookLoanDto getBookLoanDto(BookLoanReqeust bookLoanReqeust) {
        int memberId = memberDao.getMemberIdById(bookLoanReqeust.getId());
        int bookId = bookDao.getBookIdByBookName(bookLoanReqeust.getBookName());
        return BookLoanDto.of(memberId, bookId);
    }

    private void deductLoanableQuantity(BookLoanDto bookLoanDto) {
        int result = bookDao.deductLoanableQuantity(bookLoanDto);
        if(result < 0)
            throw new SqlExecuteFailException("대출가능 도서 수 차감 실패하였습니다.");
    }

    private void addBookLoanHistory(BookLoanDto bookLoanDto) {
        AddBookLoanHistoryDto addBookLoanHistoryDto = AddBookLoanHistoryDto.of(BookLoanHistoryType.BOOK_LOAN.code, bookLoanDto.getMemberId(), bookLoanDto.getBookId());
        int result = bookDao.addBookLoanHistory(addBookLoanHistoryDto);
        if(result < 0)
            throw new SqlExecuteFailException("대출 히스토리 테이블에 추가 실패하였습니다.");
    }

    private void addBooksOnLoan(BookLoanDto bookLoanDto) {
        int result = bookDao.addBooksOnLoan(bookLoanDto);
        if(result < 0)
            throw new SqlExecuteFailException("대출 중인 상태 도서 테이블에 추가 실패하였습니다.");
    }

    private void loanPossibleCheck(BookLoanDto bookLoanDto) {
        int bookLoanableQuantity = bookDao.getBookLoanableQuantity(bookLoanDto);
        if(bookLoanableQuantity < 1)
            throw new NoSuchElementException("대출 가능한 도서 수량이 없습니다.");
    }




}
