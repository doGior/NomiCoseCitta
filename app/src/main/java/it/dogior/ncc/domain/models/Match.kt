package it.dogior.ncc.domain.models

import com.google.type.DateTime

//TODO: Pensare a come implementare partite async
data class Match(
    val uid: String,
    val users: List<Int>, // List of IDs
    val categoryListId: Int,  // ID of the list of categories
    val rounds: List<Int>,  // IDs of the rounds
    val startedDateTime: DateTime, //TODO cambiare datetime con il tipo accettato da firestore
    val hasEnded: Boolean
)

