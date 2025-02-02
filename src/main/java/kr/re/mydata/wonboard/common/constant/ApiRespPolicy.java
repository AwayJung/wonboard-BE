package kr.re.mydata.wonboard.common.constant;

import org.springframework.http.HttpStatus;

/**
 * API 응답 정책 관리 Enum
 *
 * @author yrlee@mydata.re.kr
 */
public enum ApiRespPolicy {
    SUCCESS(HttpStatus.OK, 20000, "message.api.resp.policy.success"),
    SUCCESS_CREATED(HttpStatus.CREATED, 20100,"message.api.resp.policy.success_created"),
    SUCCESS_ISSUE_TOKEN(HttpStatus.OK, 20001, "message.api.resp.policy.success_issue_token"),
    // Default Error
    ERR_SYSTEM(HttpStatus.INTERNAL_SERVER_ERROR, 50000, "message.api.resp.policy.err_system"),
    ERR_DATABASE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, 50001, "message.api.resp.policy.err_database"),

    ERR_INVALID_PARAMS(HttpStatus.BAD_REQUEST, 40001, "message.api.resp.policy.err_invalid_params"),
    ERR_DUPLICATED_USER(HttpStatus.CONFLICT, 40901, "message.api.resp.policy.err_duplicated_user"),
    ERR_NOT_AUTHENTICATED(HttpStatus.UNAUTHORIZED, 40400, "message.api.resp.policy.err_authenticated"),
    ERR_INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, 40401, "message.api.resp.policy.err_invalid_refresh_token"),
    ERR_ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, 40402, "message.api.resp.policy.err_article_not_found"),
    ERR_USERDETAIL_NOT_FOUND(HttpStatus.NOT_FOUND, 40403, "message.api.resp.policy.err_userdetail_not_found"),
    ERR_USER_NOT_LOGGED_IN(HttpStatus.UNAUTHORIZED, 40404, "message.api.resp.policy.err_user_not_logged_in"),
    ERR_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, 40405, "message.api.resp.policy.err_token_expired"),
    ERR_TOKEN_INVALID(HttpStatus.UNAUTHORIZED, 40406, "message.api.resp.policy.err_token_invalid"),
    ERR_TEXT_LENGTH_EXCEEDED(HttpStatus.BAD_REQUEST, 40002, "message.api.resp.policy.err_text_length_exceeded");

    private final HttpStatus httpStatus;
    private final int code;
    private final String messageKey;

    ApiRespPolicy(HttpStatus httpStatus, int code, String messageKey) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.messageKey = messageKey;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
