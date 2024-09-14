package it.dogior.ncc.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.ui.graphics.vector.ImageVector
import it.dogior.ncc.presentation.screens.SerializableIcon

fun getIconFromSerializable(serializableIcon: SerializableIcon): ImageVector {
    return if(serializableIcon.isFilled) {
        when(serializableIcon.iconName){
            "Home" -> Icons.Filled.Home
            "List" -> Icons.AutoMirrored.Filled.List
            "Profile" -> Icons.Filled.AccountCircle
            else -> {
                Icons.Filled.QuestionMark}
        }
    } else {
        when(serializableIcon.iconName){
            "Home" -> Icons.Outlined.Home
            "List" -> Icons.AutoMirrored.Outlined.List
            "Profile" -> Icons.Outlined.AccountCircle
            else -> {
                Icons.Outlined.QuestionMark}
        }
    }
}