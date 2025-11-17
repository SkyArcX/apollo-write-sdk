package com.bluesky.apollo.exception;

import lombok.Getter;

/**
 * @author lantian
 */
@Getter
public class ApolloHttpException extends ApolloException{
    private final int statusCode;
    private final String body;

    public ApolloHttpException(int statusCode, String body) {
        super("Http status code: " + statusCode + ", body: " + body);
        this.statusCode = statusCode;
        this.body = body;
    }
}
