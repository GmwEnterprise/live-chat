package com.github.mrag.livechat.rest;

import com.github.mrag.livechat.common.BusinessException;
import com.github.mrag.livechat.common.http.HttpResponse;
import com.github.mrag.livechat.common.http.HttpResponseCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * controller 异常处理
 *
 * @author Gmw
 */
@RestControllerAdvice
public class ExceptionAdviceForController {

    /**
     * 参数校验错误处理
     *
     * @param e 参数校验错误
     * @return 响应信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public HttpResponse handler(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String errorMsg;
        if (bindingResult.getGlobalErrorCount() > 0) {
            errorMsg = bindingResult.getGlobalError().getDefaultMessage();
        } else {
            FieldError fieldError = bindingResult.getFieldError();
            errorMsg = String.format("参数%s校验失败：%s.",
                    fieldError.getField(), fieldError.getDefaultMessage());
        }
        return HttpResponse.badRequest(errorMsg);
    }

    /**
     * 业务异常处理
     *
     * @param e 异常
     * @return 响应信息
     */
    @ExceptionHandler(BusinessException.class)
    public HttpResponse handler(BusinessException e) {
        switch (e.getErrorType()) {
            case WITHOUT_TOKEN:
                return new HttpResponse(HttpResponseCode.WITHOUT_TOKEN, e.getMessage());
            case INCORRECT_PASSWORD:
                return new HttpResponse(HttpResponseCode.PASSWORD_WRONG, e.getMessage());
            case TOKEN_EXPIRED:
                return new HttpResponse(HttpResponseCode.CREDENTIALS_EXPIRED, e.getMessage());
            default:
                return new HttpResponse(HttpResponseCode.UNKNOWN, e.getMessage());
        }
    }
}
