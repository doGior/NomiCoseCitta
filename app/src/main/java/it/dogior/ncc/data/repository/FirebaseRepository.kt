package it.dogior.ncc.data.repository

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import it.dogior.ncc.data.mappers.toHashMap
import it.dogior.ncc.domain.models.CategoryList
import it.dogior.ncc.domain.models.Match
import it.dogior.ncc.domain.models.Round
import it.dogior.ncc.domain.models.User
import it.dogior.ncc.domain.repository.DatabaseRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseRepository @Inject constructor(private val firestore: FirebaseFirestore) :
    DatabaseRepository {
    private val usersCollection = "users"
    private val matchesCollection = "matches"
    private val categoryListSubcollection = "users"
    private val roundsSubcollection = "users"

    override suspend fun getUser(documentID: String): Result<DocumentSnapshot> {
        return try {
            Result.success(firestore.collection(usersCollection).document(documentID).get().await())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getListOfUsers(userIDs: List<String>): Flow<Result<DocumentSnapshot>> {
        return callbackFlow {
            userIDs.forEach {
                try {
                    trySend(
                        Result.success(
                            firestore.collection(usersCollection).document(it).get().await()
                        )
                    )
                } catch (e: Exception) {
                    trySend(Result.failure(e))
                }
            }
            awaitClose()
        }
    }

    override suspend fun addUser(user: User): Result<Void> {
//        return firestore.collection(usersCollection).document(user.uid).set(user.toHashMap())
        return try {
            Result.success(
                firestore.collection(usersCollection)
                    .document(user.uid).set(user.toHashMap()).await()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMatch(documentID: String): Result<DocumentSnapshot> {
        return try {
            Result.success(
                firestore.collection(matchesCollection).document(documentID).get().await()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getRound(
        matchDocumentID: String,
        roundDocumentID: String
    ): Result<DocumentSnapshot> {
        return try {
            Result.success(
                firestore.collection(matchesCollection).document(matchDocumentID)
                    .collection(roundsSubcollection).document(roundDocumentID).get().await()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getCategoryList(
        userDocumentID: String,
        categoryListDocumentID: String
    ): Result<DocumentSnapshot> {

        return try {
            Result.success(
                firestore.collection(usersCollection).document(userDocumentID)
                    .collection(categoryListSubcollection).document(categoryListDocumentID).get()
                    .await()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


    override suspend fun addMatch(match: Match) {
        TODO("Not yet implemented")
    }

    override suspend fun addRound(round: Round) {
        TODO("Not yet implemented")
    }

    override suspend fun addCategoryList(categoryList: CategoryList) {
        TODO("Not yet implemented")
    }

    // TODO Implementare Snapshot listener con Flow (Lo snapshot listener è quello che si aggiorna in tempo reale)

}