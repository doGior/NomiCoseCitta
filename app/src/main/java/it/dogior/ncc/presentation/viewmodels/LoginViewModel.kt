package it.dogior.ncc.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.dogior.ncc.domain.auth.AccountManager
import kotlinx.coroutines.launch

data class LoginState(
    val username: String? = null,
    val errorMessage: String? = null,
    val isLoggedIn: Boolean = false,
)

class LoginViewModel : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun handleGoogleLogIn(accountManager: AccountManager) {
        Log.d("LOGIN", "Reached Google Log In Function")
        viewModelScope.launch {
            accountManager.googleSignIn().collect { result ->
                result.fold(
                    onSuccess = {
                        state = state.copy(username = it.user?.displayName, isLoggedIn = true)
                        Log.d("LOGIN", "Success")
                    }, onFailure = {
                        state = state.copy(errorMessage = it.message)
                        Log.d("LOGIN", "Failure: ${it.message}")
                    }
                )
            }
        }
    }

}