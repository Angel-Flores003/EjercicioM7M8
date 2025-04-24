package cat.itb.m78.exercices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cat.itb.m78.exercices.Ejemplo.CameraScreen
import cat.itb.m78.exercices.Ejemplo.FeatureThatRequiresCameraPermission
import cat.itb.m78.exercices.MapCompose.MapsScreen1
import cat.itb.m78.exercices.MapCompose.P3_Project.MapsScreen

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MapsScreen1() }
    }
}

@Preview
@Composable
fun AppPreview() { App() }