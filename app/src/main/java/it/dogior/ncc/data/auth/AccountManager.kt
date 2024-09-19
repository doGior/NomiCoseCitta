package it.dogior.ncc.data.auth

import android.app.Activity
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import java.security.MessageDigest
import java.util.UUID

class AccountManager(private val activity: Activity) {
    // Credential Manager: Manages the retrieval of user credentials.
    private val credentialManager = CredentialManager.create(activity)
    private val firebaseAuth = FirebaseAuth.getInstance()

    private val firebaseWebID =
        "943381064813-bthum1bbq3l8ph6hl725n7gegcvjto1i.apps.googleusercontent.com"

    // Generate a nonce (a random number used once) used to ensure the security of the authentication request.
    private fun generateNonce(): String {
        val ranNonce: String = UUID.randomUUID().toString()
        val bytes: ByteArray = ranNonce.toByteArray()
        val md: MessageDigest = MessageDigest.getInstance("SHA-256")
        val digest: ByteArray = md.digest(bytes)
        val hashedNonce: String = digest.fold("") { str, it -> str + "%02x".format(it) }
        return hashedNonce
    }

    // Set up Google ID option (Google Sign-In parameters)
    private val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
        .setFilterByAuthorizedAccounts(false)
        .setServerClientId(firebaseWebID)
        .setAutoSelectEnabled(true) // If the user has only one google account on his phone, auto select it
        .setNonce(generateNonce())
        .build()


    suspend fun googleSignIn(): Result<AuthResult> {
        return try {
            // Request credentials
            val request: GetCredentialRequest = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            // Get the credential result
            val result = credentialManager.getCredential(activity, request)
            val credential = result.credential

            // Check if the received credential is a valid Google ID Token
            if (credential is CustomCredential && credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                val googleIdTokenCredential =
                    GoogleIdTokenCredential.createFrom(credential.data)

                val authCredential =
                    GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)

                // Using the received credentials to sign in the user via Firebase.
                val authResult = firebaseAuth.signInWithCredential(authCredential).await()

                Log.d("ACCOUNT-MANAGER", authResult.user.toString())

                Result.success(authResult)
            } else {
                throw RuntimeException("Received an invalid credential type")
            }
        } catch (e: GetCredentialCancellationException) {
            Result.failure(Exception("Sign-in was canceled. Please try again."))

        } catch (e: GoogleIdTokenParsingException) {
            Result.failure(e)
        } catch (e: FirebaseNetworkException) {
            Result.failure(e)
        }
    }

    suspend fun anonymousSignIn(): Result<AuthResult> {
        return try {
            val authResult = firebaseAuth.signInAnonymously().await()

            Log.d("ACCOUNT-MANAGER", authResult.user!!.uid)
            Result.success(authResult)
        } catch (e: GetCredentialCancellationException) {
            Result.failure(Exception("Sign-in was canceled. Please try again."))
        } catch (e: GoogleIdTokenParsingException) {
            Result.failure(e)
        } catch (e: FirebaseNetworkException) {
            Result.failure(e)
        }
    }
}
