package it.dogior.ncc.data.mappers

import it.dogior.ncc.domain.models.Round

fun Round.toHashMap(): HashMap<String, Any> {
    return hashMapOf(
        "round" to round,
        "votes" to votes
    )
}