package it.dogior.ncc.domain.repository

import com.google.firebase.firestore.DocumentSnapshot
import it.dogior.ncc.domain.models.CategoryList
import it.dogior.ncc.domain.models.Match
import it.dogior.ncc.domain.models.Round
import it.dogior.ncc.domain.models.User
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    suspend fun getUser(documentID: String): Result<DocumentSnapshot>
    suspend fun getMatch(documentID: String): Result<DocumentSnapshot>
    suspend fun getRound(matchDocumentID: String, roundDocumentID: String): Result<DocumentSnapshot>
    suspend fun getCategoryList(
        userDocumentID: String,
        categoryListDocumentID: String
    ): Result<DocumentSnapshot>

    suspend fun getListOfUsers(userIDs: List<String>): Flow<Result<DocumentSnapshot>>

    suspend fun addUser(user: User): Result<Void>
    suspend fun addMatch(match: Match)
    suspend fun addRound(round: Round)
    suspend fun addCategoryList(categoryList: CategoryList)

}