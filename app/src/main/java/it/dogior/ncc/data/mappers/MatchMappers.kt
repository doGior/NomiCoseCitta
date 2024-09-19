package it.dogior.ncc.data.mappers

import it.dogior.ncc.domain.models.Match

fun Match.toHashMap(): HashMap<String, Any> {
    return hashMapOf(
        "users" to users,
        "categoryListId" to categoryListId,
        "rounds" to rounds,
        "startedDateTime" to startedDateTime,
        "hasEnded" to hasEnded
    )
}