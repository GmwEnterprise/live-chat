package com.github.mrag.livechat.rest;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * @author Gmw
 */
@Activate
public class ExceptionAdviceForDubbo implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result;
        try {
            result = invoker.invoke(invocation);
            if (result.hasException() && GenericService.class != invoker.getInterface()) {
                Throwable exception = result.getException();
            }
            // FIXME 未完成的代码
            // TODO 解决不同模块之间的调用无法被springmvc全局异常处理器处理的问题
            // RestControllerAdvice只能处理控制器抛出的异常
            return result;
        } catch (Throwable e) {
            throw new RpcException(e);
        }
    }
}
