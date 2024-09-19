package it.dogior.ncc.domain.models

data class Round(
    val uid: String,
    val round: Int,
    val durationSeconds: Int,
    val votes: Map<Int, List<Int>>,  // Map of UserIDs and its list of votes of every category
)