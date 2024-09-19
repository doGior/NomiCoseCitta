package it.dogior.ncc.presentation.viewmodels

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.dogior.ncc.data.auth.AccountManager
import kotlinx.coroutines.launch

data class LoginState(
    val uid: String? = null,
    var username: String? = null,
    val errorMessage: String? = null,
    var isUsernameChosen: Boolean = false,
)

class LoginViewModel : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun handleLogin(anonymous: Boolean, context: Context) {
        val accountManager = AccountManager(context as Activity)

        Log.d("LOGIN", "Reached Log In Viewmodel")

        val signInFunction = if (anonymous) {
            accountManager::anonymousSignIn
        } else {
            accountManager::googleSignIn
        }

        viewModelScope.launch {
            signInFunction().fold(
                onSuccess = {
                    state = state.copy(
                        uid = it.user?.uid,
                    )
                    Log.d("LOGIN", "Success")
                }, onFailure = {
                    state = state.copy(errorMessage = it.message)
                    Log.d("LOGIN", "Failure: ${it.message}")
                }
            )
            
        }
    }
}