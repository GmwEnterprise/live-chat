package com.github.mrag.livechat.rest;

import com.github.mrag.livechat.common.BusinessException;
import com.github.mrag.livechat.common.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(ExceptionAdviceForController.class);

    @ExceptionHandler(RuntimeException.class)
    public HttpResponse handler(RuntimeException e) {
        e.printStackTrace();
        return HttpResponse.unknown(e.getMessage());
    }

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
     * 统一处理业务异常
     *
     * @param e 异常
     * @return 响应信息
     */
    @ExceptionHandler(BusinessException.class)
    public HttpResponse handler(BusinessException e) {
        switch (e.getCode()) {
            case BusinessException.WITHOUT_TOKEN:
                return HttpResponse.withoutToken(e.getMessage());
            case BusinessException.INCORRECT_PASSWORD:
                return HttpResponse.incorrectPassword(e.getMessage());
            case BusinessException.TOKEN_EXPIRED:
                return HttpResponse.tokenExpired(e.getMessage());
            default:
                return HttpResponse.unknown(e.getMessage());
        }
    }
}
