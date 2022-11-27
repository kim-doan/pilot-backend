package com.wdyj.boilerplate.exception.advice;

import com.wdyj.boilerplate.exception.CategoryNotFoundException;
import com.wdyj.boilerplate.exception.PostNotFoundException;
import com.wdyj.boilerplate.response.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class ExceptionAdvice {
    private final MessageSource messageSource;

    private String getMessage(String code){
        return getMessage(code, null);
    }

    private String getMessage(String code, Object[] args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }

    // 알 수 없는 오류
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity defaultException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse(getMessage("unKnown.code"), getMessage("unKnown.msg")), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 게시판 카테고리를 찾지 못함
    @ExceptionHandler(CategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handleCategoryNotFoundException(CategoryNotFoundException e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse(getMessage("categoryNotFound.code"), getMessage("categoryNotFound.msg")), HttpStatus.BAD_REQUEST);
    }

    // 게시글을 찾지 못함
    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity handlePostNotFoundException(PostNotFoundException e) {
        e.printStackTrace();
        return new ResponseEntity<>(new ErrorResponse(getMessage("postNotFound.code"), getMessage("postNotFound.msg")), HttpStatus.BAD_REQUEST);
    }
}
