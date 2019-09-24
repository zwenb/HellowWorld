package com.zwb.test.spring_chain_pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HandlerContext {
    HandlerContext prev;
    HandlerContext next;
    Handler handler;
    private Task task;

    private HandlerContext next() {
        return next;
    }

    private Handler handler() {
        return handler;
    }

    /**
     * 管道中的第一个方法
     */
    public void fireTaskReceived(Request request){
        invokeTaskReceived(next(), request);
    }

    /**
     * 处理接收到任务的事件
     */
    static void invokeTaskReceived(HandlerContext ctx, Request request) {
        if (ctx != null) {
            try {
                ctx.handler().receiveTask(ctx, request);
            } catch (Throwable e) {
                ctx.handler().exceptionCaught(ctx, e);
            }
        }
    }

    /**
     * 管道中的第二个方法
     * @param task
     */
    public void fireTaskFiltered(Task task) {
        invokeTaskFiltered(next(), task);
    }

    /**
     * 处理任务过滤事件
     */
    static void invokeTaskFiltered(HandlerContext ctx, Task task) {
        if (null != ctx) {
            try {
                ctx.handler().filterTask(ctx, task);
            } catch (Throwable e) {
                ctx.handler().exceptionCaught(ctx, e);
            }
        }
    }

    /**
     * 管道中的第三个方法
     * @param task
     */
    public void fireTaskExecuted(Task task) {
        invokeTaskExecuted(next(), task);
    }

    /**
     * 处理执行任务事件
     */
    static void invokeTaskExecuted(HandlerContext ctx, Task task) {
        if (null != ctx) {
            try {
                ctx.handler().executeTask(ctx, task);
            } catch (Exception e) {
                ctx.handler().exceptionCaught(ctx, e);
            }
        }
    }

    /**
     * 管道中的第四个方法
     * @param ctx
     */
    public void fireAfterCompletion(HandlerContext ctx) {
        invokeAfterCompletion(next());
    }

    /**
     * 最后一步
     */
    static void invokeAfterCompletion(HandlerContext ctx) {
        if (null != ctx) {
            ctx.handler().afterCompletion(ctx);
        }
    }


}
