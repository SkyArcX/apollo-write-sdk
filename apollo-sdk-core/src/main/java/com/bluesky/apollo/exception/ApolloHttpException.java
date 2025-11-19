package com.bluesky.apollo.exception;

import lombok.Getter;

/**
 * Apollo HTTP 异常类
 *
 * <p>该异常用于封装 Apollo Portal API 调用过程中的 HTTP 错误，
 * 包含 HTTP 状态码和响应体信息，便于问题诊断和处理。</p>
 *
 * <p>常见的 HTTP 状态码含义：</p>
 * <ul>
 *   <li>400 - 请求参数错误</li>
 *   <li>401 - 认证失败，token 无效</li>
 *   <li>403 - 权限不足</li>
 *   <li>404 - 资源不存在（如应用、环境、配置项等）</li>
 *   <li>500 - 服务器内部错误</li>
 * </ul>
 *
 * @author lantian
 * @date 2025/11/17
 * @version 1.0
 */
@Getter
public class ApolloHttpException extends ApolloException {

    /**
     * HTTP 状态码
     */
    private final int statusCode;

    /**
     * HTTP 响应体内容
     */
    private final String body;

    /**
     * 构造函数，创建 HTTP 异常
     *
     * @param statusCode HTTP 状态码
     * @param body HTTP 响应体内容
     */
    public ApolloHttpException(int statusCode, String body) {
        super("HTTP request failed with status code: " + statusCode + ", response body: " + body);
        this.statusCode = statusCode;
        this.body = body;
    }
}