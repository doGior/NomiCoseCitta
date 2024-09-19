package it.dogior.ncc.data.mappers

import it.dogior.ncc.domain.models.User

fun User.toHashMap(): HashMap<String, Any> {
    return hashMapOf(
        "username" to username,
        "propic" to propic,
        "friends" to friends
    )
}