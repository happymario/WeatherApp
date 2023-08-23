package com.mario.weather.ui.splash

import android.annotation.SuppressLint
import android.content.Context
import com.mario.weather.R
import com.mario.weather.base.BaseViewModel
import com.mario.weather.base.BaseViewState
import com.mario.weather.data.exception.AppException
import com.mario.weather.data.repository.LocalRepository
import com.mario.weather.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@SuppressLint("StaticFieldLeak")
@HiltViewModel
class SplashViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private var repository: WeatherRepository,
    private var localRepository: LocalRepository
) : BaseViewModel() {
    private val _state = MutableStateFlow(SplashViewState(isLoading = false))
    val state: StateFlow<SplashViewState> = _state

    init {
        _state.update {
            it.copy(isRequestPermission = true)
        }
    }

    fun getAppInfo() {
        launchAPI {
            showLoading()

            repository.getAppInfo().collect { it ->
                val appInfo = it
                localRepository.setAppInfo(appInfo)
                _state.update { viewstate ->
                    viewstate.copy(
                        isLoadedData = true,
                    )
                }
            }
        }
    }

    fun permissionIsNotGranted() {
        val error = AppException.AlertException(
            context.getString(R.string.error_message_permission_not_granted)
        )
        showError(error)
    }

    fun completePermissionRequest() {
        _state.update {
            it.copy(
                isRequestPermission = false,
            )
        }
    }

    override fun showLoading() {
        _state.update {
            it.copy(isLoading = true)
        }
    }

    override fun hideLoading() {
        _state.update {
            it.copy(
                isLoading = false,
            )
        }
    }

    override fun showError(error: Throwable) {
        if (_state.value.error == null) {
            _state.update {
                it.copy(isLoading = false, error = error)
            }
        }
    }

    override fun hideError() {
        _state.update {
            it.copy(
                isLoading = false,
                error = null,
            )
        }
    }
}

data class SplashViewState(
    override val isLoading: Boolean = false,
    override val error: Throwable? = null,
    val isRequestPermission: Boolean = false,
    val isLoadedData: Boolean = false
) : BaseViewState()