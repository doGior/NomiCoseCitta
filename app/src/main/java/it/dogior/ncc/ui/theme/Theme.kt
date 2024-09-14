package it.dogior.ncc
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import it.dogior.ncc.ui.theme.AppTypography
import it.dogior.ncc.ui.theme.backgroundDark
import it.dogior.ncc.ui.theme.backgroundDarkHighContrast
import it.dogior.ncc.ui.theme.backgroundDarkMediumContrast
import it.dogior.ncc.ui.theme.backgroundLight
import it.dogior.ncc.ui.theme.backgroundLightHighContrast
import it.dogior.ncc.ui.theme.backgroundLightMediumContrast
import it.dogior.ncc.ui.theme.errorContainerDark
import it.dogior.ncc.ui.theme.errorContainerDarkHighContrast
import it.dogior.ncc.ui.theme.errorContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.errorContainerLight
import it.dogior.ncc.ui.theme.errorContainerLightHighContrast
import it.dogior.ncc.ui.theme.errorContainerLightMediumContrast
import it.dogior.ncc.ui.theme.errorDark
import it.dogior.ncc.ui.theme.errorDarkHighContrast
import it.dogior.ncc.ui.theme.errorDarkMediumContrast
import it.dogior.ncc.ui.theme.errorLight
import it.dogior.ncc.ui.theme.errorLightHighContrast
import it.dogior.ncc.ui.theme.errorLightMediumContrast
import it.dogior.ncc.ui.theme.inverseOnSurfaceDark
import it.dogior.ncc.ui.theme.inverseOnSurfaceDarkHighContrast
import it.dogior.ncc.ui.theme.inverseOnSurfaceDarkMediumContrast
import it.dogior.ncc.ui.theme.inverseOnSurfaceLight
import it.dogior.ncc.ui.theme.inverseOnSurfaceLightHighContrast
import it.dogior.ncc.ui.theme.inverseOnSurfaceLightMediumContrast
import it.dogior.ncc.ui.theme.inversePrimaryDark
import it.dogior.ncc.ui.theme.inversePrimaryDarkHighContrast
import it.dogior.ncc.ui.theme.inversePrimaryDarkMediumContrast
import it.dogior.ncc.ui.theme.inversePrimaryLight
import it.dogior.ncc.ui.theme.inversePrimaryLightHighContrast
import it.dogior.ncc.ui.theme.inversePrimaryLightMediumContrast
import it.dogior.ncc.ui.theme.inverseSurfaceDark
import it.dogior.ncc.ui.theme.inverseSurfaceDarkHighContrast
import it.dogior.ncc.ui.theme.inverseSurfaceDarkMediumContrast
import it.dogior.ncc.ui.theme.inverseSurfaceLight
import it.dogior.ncc.ui.theme.inverseSurfaceLightHighContrast
import it.dogior.ncc.ui.theme.inverseSurfaceLightMediumContrast
import it.dogior.ncc.ui.theme.onBackgroundDark
import it.dogior.ncc.ui.theme.onBackgroundDarkHighContrast
import it.dogior.ncc.ui.theme.onBackgroundDarkMediumContrast
import it.dogior.ncc.ui.theme.onBackgroundLight
import it.dogior.ncc.ui.theme.onBackgroundLightHighContrast
import it.dogior.ncc.ui.theme.onBackgroundLightMediumContrast
import it.dogior.ncc.ui.theme.onErrorContainerDark
import it.dogior.ncc.ui.theme.onErrorContainerDarkHighContrast
import it.dogior.ncc.ui.theme.onErrorContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.onErrorContainerLight
import it.dogior.ncc.ui.theme.onErrorContainerLightHighContrast
import it.dogior.ncc.ui.theme.onErrorContainerLightMediumContrast
import it.dogior.ncc.ui.theme.onErrorDark
import it.dogior.ncc.ui.theme.onErrorDarkHighContrast
import it.dogior.ncc.ui.theme.onErrorDarkMediumContrast
import it.dogior.ncc.ui.theme.onErrorLight
import it.dogior.ncc.ui.theme.onErrorLightHighContrast
import it.dogior.ncc.ui.theme.onErrorLightMediumContrast
import it.dogior.ncc.ui.theme.onPrimaryContainerDark
import it.dogior.ncc.ui.theme.onPrimaryContainerDarkHighContrast
import it.dogior.ncc.ui.theme.onPrimaryContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.onPrimaryContainerLight
import it.dogior.ncc.ui.theme.onPrimaryContainerLightHighContrast
import it.dogior.ncc.ui.theme.onPrimaryContainerLightMediumContrast
import it.dogior.ncc.ui.theme.onPrimaryDark
import it.dogior.ncc.ui.theme.onPrimaryDarkHighContrast
import it.dogior.ncc.ui.theme.onPrimaryDarkMediumContrast
import it.dogior.ncc.ui.theme.onPrimaryLight
import it.dogior.ncc.ui.theme.onPrimaryLightHighContrast
import it.dogior.ncc.ui.theme.onPrimaryLightMediumContrast
import it.dogior.ncc.ui.theme.onSecondaryContainerDark
import it.dogior.ncc.ui.theme.onSecondaryContainerDarkHighContrast
import it.dogior.ncc.ui.theme.onSecondaryContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.onSecondaryContainerLight
import it.dogior.ncc.ui.theme.onSecondaryContainerLightHighContrast
import it.dogior.ncc.ui.theme.onSecondaryContainerLightMediumContrast
import it.dogior.ncc.ui.theme.onSecondaryDark
import it.dogior.ncc.ui.theme.onSecondaryDarkHighContrast
import it.dogior.ncc.ui.theme.onSecondaryDarkMediumContrast
import it.dogior.ncc.ui.theme.onSecondaryLight
import it.dogior.ncc.ui.theme.onSecondaryLightHighContrast
import it.dogior.ncc.ui.theme.onSecondaryLightMediumContrast
import it.dogior.ncc.ui.theme.onSurfaceDark
import it.dogior.ncc.ui.theme.onSurfaceDarkHighContrast
import it.dogior.ncc.ui.theme.onSurfaceDarkMediumContrast
import it.dogior.ncc.ui.theme.onSurfaceLight
import it.dogior.ncc.ui.theme.onSurfaceLightHighContrast
import it.dogior.ncc.ui.theme.onSurfaceLightMediumContrast
import it.dogior.ncc.ui.theme.onSurfaceVariantDark
import it.dogior.ncc.ui.theme.onSurfaceVariantDarkHighContrast
import it.dogior.ncc.ui.theme.onSurfaceVariantDarkMediumContrast
import it.dogior.ncc.ui.theme.onSurfaceVariantLight
import it.dogior.ncc.ui.theme.onSurfaceVariantLightHighContrast
import it.dogior.ncc.ui.theme.onSurfaceVariantLightMediumContrast
import it.dogior.ncc.ui.theme.onTertiaryContainerDark
import it.dogior.ncc.ui.theme.onTertiaryContainerDarkHighContrast
import it.dogior.ncc.ui.theme.onTertiaryContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.onTertiaryContainerLight
import it.dogior.ncc.ui.theme.onTertiaryContainerLightHighContrast
import it.dogior.ncc.ui.theme.onTertiaryContainerLightMediumContrast
import it.dogior.ncc.ui.theme.onTertiaryDark
import it.dogior.ncc.ui.theme.onTertiaryDarkHighContrast
import it.dogior.ncc.ui.theme.onTertiaryDarkMediumContrast
import it.dogior.ncc.ui.theme.onTertiaryLight
import it.dogior.ncc.ui.theme.onTertiaryLightHighContrast
import it.dogior.ncc.ui.theme.onTertiaryLightMediumContrast
import it.dogior.ncc.ui.theme.outlineDark
import it.dogior.ncc.ui.theme.outlineDarkHighContrast
import it.dogior.ncc.ui.theme.outlineDarkMediumContrast
import it.dogior.ncc.ui.theme.outlineLight
import it.dogior.ncc.ui.theme.outlineLightHighContrast
import it.dogior.ncc.ui.theme.outlineLightMediumContrast
import it.dogior.ncc.ui.theme.outlineVariantDark
import it.dogior.ncc.ui.theme.outlineVariantDarkHighContrast
import it.dogior.ncc.ui.theme.outlineVariantDarkMediumContrast
import it.dogior.ncc.ui.theme.outlineVariantLight
import it.dogior.ncc.ui.theme.outlineVariantLightHighContrast
import it.dogior.ncc.ui.theme.outlineVariantLightMediumContrast
import it.dogior.ncc.ui.theme.primaryContainerDark
import it.dogior.ncc.ui.theme.primaryContainerDarkHighContrast
import it.dogior.ncc.ui.theme.primaryContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.primaryContainerLight
import it.dogior.ncc.ui.theme.primaryContainerLightHighContrast
import it.dogior.ncc.ui.theme.primaryContainerLightMediumContrast
import it.dogior.ncc.ui.theme.primaryDark
import it.dogior.ncc.ui.theme.primaryDarkHighContrast
import it.dogior.ncc.ui.theme.primaryDarkMediumContrast
import it.dogior.ncc.ui.theme.primaryLight
import it.dogior.ncc.ui.theme.primaryLightHighContrast
import it.dogior.ncc.ui.theme.primaryLightMediumContrast
import it.dogior.ncc.ui.theme.scrimDark
import it.dogior.ncc.ui.theme.scrimDarkHighContrast
import it.dogior.ncc.ui.theme.scrimDarkMediumContrast
import it.dogior.ncc.ui.theme.scrimLight
import it.dogior.ncc.ui.theme.scrimLightHighContrast
import it.dogior.ncc.ui.theme.scrimLightMediumContrast
import it.dogior.ncc.ui.theme.secondaryContainerDark
import it.dogior.ncc.ui.theme.secondaryContainerDarkHighContrast
import it.dogior.ncc.ui.theme.secondaryContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.secondaryContainerLight
import it.dogior.ncc.ui.theme.secondaryContainerLightHighContrast
import it.dogior.ncc.ui.theme.secondaryContainerLightMediumContrast
import it.dogior.ncc.ui.theme.secondaryDark
import it.dogior.ncc.ui.theme.secondaryDarkHighContrast
import it.dogior.ncc.ui.theme.secondaryDarkMediumContrast
import it.dogior.ncc.ui.theme.secondaryLight
import it.dogior.ncc.ui.theme.secondaryLightHighContrast
import it.dogior.ncc.ui.theme.secondaryLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceBrightDark
import it.dogior.ncc.ui.theme.surfaceBrightDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceBrightDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceBrightLight
import it.dogior.ncc.ui.theme.surfaceBrightLightHighContrast
import it.dogior.ncc.ui.theme.surfaceBrightLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerDark
import it.dogior.ncc.ui.theme.surfaceContainerDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighDark
import it.dogior.ncc.ui.theme.surfaceContainerHighDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighLight
import it.dogior.ncc.ui.theme.surfaceContainerHighLightHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighestDark
import it.dogior.ncc.ui.theme.surfaceContainerHighestDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighestDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighestLight
import it.dogior.ncc.ui.theme.surfaceContainerHighestLightHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerHighestLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerLight
import it.dogior.ncc.ui.theme.surfaceContainerLightHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowDark
import it.dogior.ncc.ui.theme.surfaceContainerLowDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowLight
import it.dogior.ncc.ui.theme.surfaceContainerLowLightHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowestDark
import it.dogior.ncc.ui.theme.surfaceContainerLowestDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowestDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowestLight
import it.dogior.ncc.ui.theme.surfaceContainerLowestLightHighContrast
import it.dogior.ncc.ui.theme.surfaceContainerLowestLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceDark
import it.dogior.ncc.ui.theme.surfaceDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceDimDark
import it.dogior.ncc.ui.theme.surfaceDimDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceDimDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceDimLight
import it.dogior.ncc.ui.theme.surfaceDimLightHighContrast
import it.dogior.ncc.ui.theme.surfaceDimLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceLight
import it.dogior.ncc.ui.theme.surfaceLightHighContrast
import it.dogior.ncc.ui.theme.surfaceLightMediumContrast
import it.dogior.ncc.ui.theme.surfaceVariantDark
import it.dogior.ncc.ui.theme.surfaceVariantDarkHighContrast
import it.dogior.ncc.ui.theme.surfaceVariantDarkMediumContrast
import it.dogior.ncc.ui.theme.surfaceVariantLight
import it.dogior.ncc.ui.theme.surfaceVariantLightHighContrast
import it.dogior.ncc.ui.theme.surfaceVariantLightMediumContrast
import it.dogior.ncc.ui.theme.tertiaryContainerDark
import it.dogior.ncc.ui.theme.tertiaryContainerDarkHighContrast
import it.dogior.ncc.ui.theme.tertiaryContainerDarkMediumContrast
import it.dogior.ncc.ui.theme.tertiaryContainerLight
import it.dogior.ncc.ui.theme.tertiaryContainerLightHighContrast
import it.dogior.ncc.ui.theme.tertiaryContainerLightMediumContrast
import it.dogior.ncc.ui.theme.tertiaryDark
import it.dogior.ncc.ui.theme.tertiaryDarkHighContrast
import it.dogior.ncc.ui.theme.tertiaryDarkMediumContrast
import it.dogior.ncc.ui.theme.tertiaryLight
import it.dogior.ncc.ui.theme.tertiaryLightHighContrast
import it.dogior.ncc.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun NomiCoseCittaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
  val colorScheme = when {
//      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//          val context = LocalContext.current
//          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//      }

      darkTheme -> darkScheme
      else -> lightScheme
  }


  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

