package it.dogior.ncc.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import it.dogior.ncc.CurrentTheme
import it.dogior.ncc.LocalTheme
import it.dogior.ncc.R

@Composable
fun GoogleButtonAppearance(enabled: Boolean = true) {
    val darkMode = LocalTheme.current.darkMode
    val resource =
        if (darkMode) R.drawable.continue_with_google_light_rd_ctn
        else R.drawable.continue_with_google_dark_rd_ctn
    if (enabled) {
        Image(painter = painterResource(id = resource), contentDescription = "")
    } else {
        Image(
            painter = painterResource(id = R.drawable.continue_with_google_neutral_rd_ctn),
            contentDescription = ""
        )
    }
}

@Preview
@Composable
fun GoogleButtonAppearancePreview() {
    CompositionLocalProvider(
        LocalTheme provides CurrentTheme()
    ) {
        LocalTheme.current.darkMode = true
        GoogleButtonAppearance()
    }
}

@Preview
@Composable
fun GoogleButtonAppearancePreviewDark() {
    CompositionLocalProvider(
        LocalTheme provides CurrentTheme()
    ) {
        LocalTheme.current.darkMode = false
        GoogleButtonAppearance()
    }
}