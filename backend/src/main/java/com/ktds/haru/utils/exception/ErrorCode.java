package com.ktds.haru.utils.exception;

import static org.springframework.http.HttpStatus.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    /* 400 BAD_REQUEST : 클라이언트 요청이 유효하지 않아 더 이상 작업을 진행하지 않는 경우 */


    /* 401 UNAUTHORIZED : 클라이언트가 요청한 리소스에 대한 인증 정보가 없거나 잘못된 경우 */
    INVALID_CLIENT_TOKEN(UNAUTHORIZED, "유효하지 않은 클라이언트 토큰입니다."),

    /* 403 FORBIDDEN : 클라이언트가 요청한 리소스에 대한 권한이 없는 경우 */
    FORBIDDEN_USER(FORBIDDEN, "권한이 없는 요청입니다."),

    /* 404 NTO_FOUND : 해당하는 DATA를 찾을 수 없음 */
    USER_NOT_FOUND(NOT_FOUND, "해당 사용자 정보를 찾을 수 없습니다"),
    DIARY_NOT_FOUND(NOT_FOUND, "존재하지 않는 일기장입니다."),
    SCHOOL_NOT_FOUND(NOT_FOUND, "존재하지 않는 학급입니다."),


    /* 409 CONFLICT : 클라이언트의 요청이 서버 상태와 충돌하는 경우 */
    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다.");

    private final HttpStatus httpStatus;
    private final String message;
}