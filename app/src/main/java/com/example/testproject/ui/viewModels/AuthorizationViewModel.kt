package com.example.testproject.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.requesters.IAuthRequester
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authRequester: IAuthRequester
) : ViewModel() {
    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String>
        get() = _phone

    private val _pass = MutableLiveData<String>()
    val pass: LiveData<String>
        get() = _pass

   /* init {
        viewModelScope.launch {
            authRequester.loginByCredential("+380", "671112233", "qwerty")
        }
    }*/

    fun auth(){
        viewModelScope.launch {
            authRequester.loginByCredential("+380", "671112233", "qwerty")
        }
    }
}