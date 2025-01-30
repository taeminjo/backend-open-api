package com.nangpun.backend.common.exception

data class CommonResponse<T>(val code: String = "200", val message: String = "success", val data: T)
