package com.mario.weather.ui.tuto

import com.mario.weather.base.BaseViewModel
import com.mario.weather.base.BaseViewState
import com.mario.weather.data.repository.LocalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TutoViewModel @Inject constructor(
    private var localRepository: LocalRepository
) : BaseViewModel() {
    private val _state = MutableStateFlow(TutoViewState(isLoading = false))
    val state: StateFlow<TutoViewState> = _state

    init {
        _state.update {
            it.copy(tutoStep = 0)
        }
    }

    fun nextStep() {
        _state.update {
            if ((it.tutoStep + 1) > 4) {
                it.copy(tutoStep = 4)
            } else {
                it.copy(tutoStep = (it.tutoStep + 1))
            }
        }
    }

    fun prevStep() {
        _state.update {
            if ((it.tutoStep - 1) < 0) {
                it.copy(tutoStep = 0)
            } else {
                it.copy(tutoStep = (it.tutoStep - 1))
            }
        }
    }
}


data class TutoViewState(
    override val isLoading: Boolean = false,
    override val error: Throwable? = null,
    val tutoStep: Int = 0
) : BaseViewState()