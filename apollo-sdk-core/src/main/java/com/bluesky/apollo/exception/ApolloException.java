package com.bluesky.apollo.exception;

/**
 * Apollo SDK 基础异常类
 *
 * <p>这是 Apollo SDK 中所有异常的基类，用于封装 Apollo 相关操作中的错误信息。</p>
 *
 * <p>该异常继承自 {@link RuntimeException}，属于运行时异常，不需要强制捕获。</p>
 *
 * @author lantian
 * @date 2025/11/17
 * @version 1.0
 */
public class ApolloException extends RuntimeException {

    /**
     * 构造函数，创建带有错误消息的异常
     *
     * @param message 错误消息
     */
    public ApolloException(String message) {
        super(message);
    }

    /**
     * 构造函数，创建带有错误消息和原因的异常
     *
     * @param message 错误消息
     * @param cause 异常原因
     */
    public ApolloException(String message, Throwable cause) {
        super(message, cause);
    }
}