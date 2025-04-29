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
fun MapScreen(onListClick: () -> Unit){
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
            state = MarkerState(position = LatLng(41.5, 2.3)),
            title = "Marker in Spain"
        )
    }
    AddMarkerScreen()
    {
        
    }
}

@Composable
fun AddMarkerScreen(content: () -> Unit) {

}