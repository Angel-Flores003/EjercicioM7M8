package cat.itb.m78.exercices

import androidx.compose.runtime.*
import cat.itb.m78.exercices.Api.Country.countriescreen
import cat.itb.m78.exercices.Api.CountryMateu.CountriesScreen
import cat.itb.m78.exercices.Api.Estatembassaments.EmbassamentsScreen
import cat.itb.m78.exercices.Projectwireframe.WireframeDetailScreen
import cat.itb.m78.exercices.Projectwireframe.WireframeMainScreen
import cat.itb.m78.exercices.Projectwireframe.WireframeScreen
import cat.itb.m78.exercices.Prova_M78.P2.Extension2ScreenList
import cat.itb.m78.exercices.Prova_M78.P2.Prova2ScreenList
import cat.itb.m78.exercices.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    Prova2ScreenList()
}