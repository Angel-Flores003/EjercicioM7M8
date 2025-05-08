package cat.itb.m78.exercices.MapCompose.P3_Project

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState

@SuppressLint("UnrememberedMutableState")
@Composable
fun MapScreen() {
    GoogleMap(
        googleMapOptionsFactory = {
            GoogleMapOptions().mapId("DEMO_MAP_ID")
        },
    ) {
        AdvancedMarker(
            state = MarkerState(position = LatLng(-33.0, 151.5)),
            title = "Marker in Sydney"
        )
        AdvancedMarker(
            state = MarkerState(position = LatLng(41.38879, 2.15899)),
            title = "Marker in Spain"
        )
        AdvancedMarker(
            state = MarkerState(position = LatLng(41.4534, 2.18629)),
            title = "Institut Tecnològic de Barcelona (ITB)"
        )
    }
//    AddMarkerScreen()
//    {
//
//    }
}

@Composable
fun AddMarkerScreen(content: () -> Unit) {

}