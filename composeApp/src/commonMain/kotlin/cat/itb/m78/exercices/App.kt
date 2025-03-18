package cat.itb.m78.exercices

import androidx.compose.runtime.*
import cat.itb.m78.exercices.Api.Country.countriescreen
import cat.itb.m78.exercices.Api.CountryMateu.CountriesScreen
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    countriescreen()
}