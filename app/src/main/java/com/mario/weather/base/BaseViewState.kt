package com.mario.weather.base

open class BaseViewState(
    open val isLoading: Boolean = false,
    open val error: Throwable? = null,
)
