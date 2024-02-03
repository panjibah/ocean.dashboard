package com.bca.ocean.dashboard.erates.util;



import com.bca.ocean.dashboard.erates.model.io.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {
    
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<BaseResponse> handleHttpRequestMethodNotSupportedException(HttpServletRequest req, HttpRequestMethodNotSupportedException e) {
		BaseResponse response = new BaseResponse();
        response.setError(
                "TBD-00-000",
                "Metode tidak diizinkan",
                "Method not allowed");
        response.setHttpStatusCode(HttpStatus.BAD_REQUEST);
        log.error("Method not allowed");
        return new ResponseEntity<>(response, response.getHttpStatusCode());
    }
}

