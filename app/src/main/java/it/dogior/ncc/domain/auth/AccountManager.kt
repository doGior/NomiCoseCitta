package it.dogior.ncc.domain.auth

import android.app.Activity
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.security.MessageDigest
import java.util.UUID


class AccountManager(private val activity: Activity) {
    private val credentialManager = CredentialManager.create(activity)

    suspend fun googleSignIn(): Flow<Result<AuthResult>> {
        /**
         * Explanation:
         *
         *     Credential Manager: Manages the retrieval of user credentials.
         *     Nonce: A random number used to ensure the security of the authentication request.
         *     Google ID Option: Configures the Google Sign-In parameters.
         *     Credential Request: Sends a request to get the user’s credentials.
         *     Credential Check: Verifies the type of credential received.
         *     Firebase Authentication: Uses the received credentials to sign in the user via Firebase.
         **/
        val firebaseAuth = FirebaseAuth.getInstance()
        return callbackFlow {
            try {
                // Generate a nonce (a random number used once)
                val ranNonce: String = UUID.randomUUID().toString()
                val bytes: ByteArray = ranNonce.toByteArray()
                val md: MessageDigest = MessageDigest.getInstance("SHA-256")
                val digest: ByteArray = md.digest(bytes)
                val hashedNonce: String = digest.fold("") { str, it -> str + "%02x".format(it) }

                // Set up Google ID option
                val googleIdOption: GetGoogleIdOption = GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId("943381064813-bthum1bbq3l8ph6hl725n7gegcvjto1i.apps.googleusercontent.com")
                    .setAutoSelectEnabled(true)
                    .setNonce(hashedNonce)
                    .build()

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
                    val authResult = firebaseAuth.signInWithCredential(authCredential).await()
                    trySend(Result.success(authResult))
                } else {
                    throw RuntimeException("Received an invalid credential type")
                }
            } catch (e: GetCredentialCancellationException) {
                trySend(Result.failure(Exception("Sign-in was canceled. Please try again.")))

            } catch (e: GoogleIdTokenParsingException) {
                trySend(Result.failure(e))
            }
            awaitClose { }
        }
    }
}