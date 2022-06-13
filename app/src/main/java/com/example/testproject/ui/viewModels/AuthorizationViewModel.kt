package com.example.testproject.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.constans.DefaultAppConst
import com.example.testproject.enums.EResultType
import com.example.testproject.observerUseCase.IAuthObserverUseCase
import com.example.testproject.repositories.IAuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authRepository: IAuthRepository,
    private val observerUseCase: IAuthObserverUseCase
) : ViewModel() {
    private var _phone = MutableLiveData<String>().apply { value = "+380671112233" }
    val phone: LiveData<String>
        get() = _phone

    private var _pass = MutableLiveData<String>().apply { value = "qwerty" }
    val pass: LiveData<String>
        get() = _pass

    private var _code = String().apply { isEmpty() }

    private val _resultType = MutableLiveData<EResultType>()
    val resultType: LiveData<EResultType>
        get() = _resultType

    init {
        viewModelScope.launch {
            observerUseCase.subscribeToken().collect {
                _resultType.value = it
            }

        }
    }

    fun auth() {
        viewModelScope.launch {
            _pass.value?.let { pass ->
                _phone.value?.let { phone ->
                    authRepository.auth(
                        _code,
                        phone.trimMargin(DefaultAppConst.COUNTRY_CODE), pass
                    )
                }
            }
        }
    }

    fun setValues(phone: String, pass: String): Boolean {
        var result = false

        if (pass.isNotEmpty() && phone.isNotEmpty()) {
            _pass.value = pass
            _phone.value = phone
            result = checkPhoneCode()
        }

        return result
    }

    private fun checkPhoneCode(): Boolean {
        var result = false

        if (_phone.value?.contains(DefaultAppConst.COUNTRY_CODE) == true) {
            result = true
            _code = DefaultAppConst.COUNTRY_CODE
        }

        return result
    }

}