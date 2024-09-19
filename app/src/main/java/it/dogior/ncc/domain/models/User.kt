package it.dogior.ncc.domain.models

import it.dogior.ncc.R

data class User(
    val uid: String,
    val username: String,
    val propic: String,
    val friends: List<String> = emptyList() // List of IDs
)

enum class Propic(val resource: Int) {
    BIRD(R.drawable.propic_bird), BROWN_HORSE(R.drawable.propic_brown_horse),
    WHITE_HORSE(R.drawable.propic_white_horse), COW(R.drawable.propic_cow),
    FISH(R.drawable.propic_fish), OCTOPUS(R.drawable.propic_octopus),
}