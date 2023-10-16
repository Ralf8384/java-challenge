package jp.co.axa.apidemo.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jp.co.axa.apidemo.utils.Result;

/**
 * <pre>
 * ExceptionHandler
 * </pre>
 * @author Yin
 * @version 1.0
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandling {


    /**
     * exception<br>
     * <br>
     * ExceptionHandler
     * 
     * @param Exception e
     * @return Result Error Message
     */
    @ExceptionHandler(Exception.class)
    public Result exception(Exception e) {
        return Result.error(e.getMessage());
    }




}
