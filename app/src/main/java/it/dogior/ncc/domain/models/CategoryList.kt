package it.dogior.ncc.domain.models

import it.dogior.ncc.R
import kotlinx.serialization.Serializable

@Serializable
data class CategoryList(
    val uid: String,
    val icon: CategoryIcon,
    val color: CategoryColor,
    val categories: List<String> // List of categories
)

@Serializable
enum class CategoryColor(val hexValue: String) {
    RED("FF0000"),
    ORANGE("FF8000"),
    YELLOW("FFFF00"),
    GREEN("00FF00"),
    TEAL("008080"),
    BLUE("0000FF"),
    PURPLE("8000FF")
}


// TODO cambiare le icone e prendere quelle da ionicons
@Serializable
enum class CategoryIcon(val resource: Int) {
    GAMEPAD(R.drawable.ionic_game_controller_icon),
    BED(R.drawable.ionic_bed_icon),
    BEER(R.drawable.ionic_car_sport_icon),
    CAR(R.drawable.ionic_car_sport_icon),
    EARTH(R.drawable.ionic_earth_icon),
    FLAME(R.drawable.ionic_flame_icon),
    FLASH(R.drawable.ionic_flash_icon),
    FOOTBALL(R.drawable.ionic_football_icon),
    HEADSET(R.drawable.ionic_headset_icon),
    ICE_CREAM(R.drawable.ionic_ice_cream_icon),
    MAN(R.drawable.ionic_man_icon),
    SKULL(R.drawable.ionic_skull_icon),
    SPARKLES(R.drawable.ionic_sparkles_icon),
    TELESCOPE(R.drawable.ionic_telescope_icon),
    WOMAN(R.drawable.ionic_woman_icon),
}