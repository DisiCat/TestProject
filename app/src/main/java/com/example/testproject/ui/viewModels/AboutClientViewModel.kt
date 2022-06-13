package com.example.testproject.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.constans.DefaultAppConst
import com.example.testproject.entity.UserModel
import com.example.testproject.repositories.IClientRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AboutClientViewModel @Inject constructor(
    private val repository: IClientRepository

) : ViewModel() {

    private val _name = MutableLiveData<String>().apply { value = "---" }
    val name: LiveData<String>
        get() = _name

    private val _surname = MutableLiveData<String>().apply { value = "---" }
    val surname: LiveData<String>
        get() = _surname

    private val _phone = MutableLiveData<String>().apply { value = "---" }
    val phone: LiveData<String>
        get() = _phone

    private var client: UserModel? = null

    init {
        viewModelScope.launch {
            client = repository.getClientById()

        }.invokeOnCompletion {
            client?.let {
                _name.value = client?.name
                _surname.value = client?.secondName
                _phone.value = DefaultAppConst.COUNTRY_CODE + client?.phoneNumber
            }
        }

    }

}