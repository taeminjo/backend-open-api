package com.nangpun.backend.common.exception

open class BackendException(val errorCode: ErrorCode) : GlobalException()

class UnknownException : BackendException(ErrorCode.ERR000)

enum class ErrorCode(val code: String, val message: String) {
    ERR000("ERR000", "알 수 없는 에러가 발생했습니다."),
}