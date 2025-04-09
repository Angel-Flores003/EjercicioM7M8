package cat.itb.m78.exercices.Ejemplo

import androidx.camera.compose.CameraXViewfinder
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CameraScreen() {
    val viewModel = viewModel { CameraViewModel() }
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(lifecycleOwner) {
        viewModel.bindToCamera(context.applicationContext, lifecycleOwner)
    }
    val surfaceRequest = viewModel.surferRequest.value
    val imageCaptureUseCase = viewModel.imageCaptureUseCase
    surfaceRequest?.let { request ->
        Box {
            CameraXViewfinder(
                surfaceRequest = request,
                modifier = Modifier.fillMaxSize()
            )
            Button({ takePhoto(context, imageCaptureUseCase) },
                modifier = Modifier.align(Alignment.BottomCenter).padding(50.dp)) {
                Text("Take Photo")
            }
        }
    }
}