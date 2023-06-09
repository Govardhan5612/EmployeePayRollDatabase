package com.example.mySqlDatabase.exception;

import com.example.mySqlDatabase.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgumentHandler(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();

        List<String> errorMessage = errorList.stream().map(objError -> objError.getDefaultMessage()).collect(Collectors.toList());
        ResponseDto dto = new ResponseDto("Check the User Details are Processing", errorMessage);
        return new ResponseEntity<ResponseDto>(dto, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ResponseDto> idException(UserException exception){
        ResponseDto dto = new ResponseDto("Searching the User Id",exception.getMessage());
        return new ResponseEntity<ResponseDto>(dto,HttpStatus.BAD_REQUEST);
    }


}
