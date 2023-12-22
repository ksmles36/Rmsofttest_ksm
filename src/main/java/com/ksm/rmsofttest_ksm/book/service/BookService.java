package com.ksm.rmsofttest_ksm.book.service;

import com.ksm.rmsofttest_ksm.book.dao.BookDao;
import com.ksm.rmsofttest_ksm.book.dto.BookRegistrationDto;
import com.ksm.rmsofttest_ksm.book.dto.UpdateBookQuantityDto;
import com.ksm.rmsofttest_ksm.exception.SqlExecuteFailException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookDao bookDao;

    public void bookRegistration(BookRegistrationDto bookRegistrationDto) {
        if(isExistBookName(bookRegistrationDto.getBookName())){
            addBookQuantity(bookRegistrationDto);
            return;
        }
        newBookRegistration(bookRegistrationDto);
    }

    private void newBookRegistration(BookRegistrationDto bookRegistrationDto) {
        int result = bookDao.bookRegistration(bookRegistrationDto);
        if(result < 0)
            throw new SqlExecuteFailException("신규 도서 등록에 실패하였습니다.");
    }

    private void addBookQuantity(BookRegistrationDto bookRegistrationDto) {
        int result = bookDao.bookQuantityAdd(bookRegistrationDto);
        if(result < 0)
            throw new SqlExecuteFailException("도서 수량 증가에 실패하였습니다.");
    }

    private boolean isExistBookName(String bookName) {
        int count = bookDao.isExistBookName(bookName);
        if(count > 0)
            return true;
        return false;
    }

    public void updateBookQuantity(UpdateBookQuantityDto updateBookQuantityDto) {
        int count = bookDao.updateBookQuantity(updateBookQuantityDto);
        if(count < 0)
            throw new SqlExecuteFailException("도서 수량 수정에 실패하였습니다.");
    }
}
