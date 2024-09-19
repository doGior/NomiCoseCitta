package it.dogior.ncc.data.mappers

import it.dogior.ncc.domain.models.CategoryList

fun CategoryList.toHashMap(): HashMap<String, Any> {
    return hashMapOf(
        "icon" to icon,
        "color" to color,
        "categories" to categories
    )
}