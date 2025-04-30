package cat.itb.m78.exercices.MapCompose.P3_Project

import android.content.Context
import android.net.Uri
import androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.core.SurfaceRequest
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.lifecycle.awaitInstance
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cat.itb.m78.exercices.MapCompose.MapsScreen1
import kotlinx.coroutines.awaitCancellation
import kotlinx.serialization.Serializable

object ProjectScreens {
    @Serializable
    data object DraweMenu
    @Serializable
    data object Map
    @Serializable
    data object List
}

@Composable
fun ProjectViewModel() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ProjectScreens.DraweMenu) {
        composable<ProjectScreens.DraweMenu> {
            DrawerMenu(
                onMapClick = { navController.navigate(ProjectScreens.Map) },
                onListClick = { navController.navigate(ProjectScreens.List) }
            )
        }
        composable<ProjectScreens.Map> {
            MapScreen(
                onListClick = { navController.navigate(ProjectScreens.List) }
            )
        }
        composable<ProjectScreens.List> {
            ListScreen(
                onMapClick = { navController.navigate(ProjectScreens.Map) }
            )
        }
    }
}

class ProjectViewModel1() : ViewModel() {
    var addMarkerState = mutableStateOf(false)
    val drawerMenuState = mutableStateOf(false)
    val listScreen = mutableStateOf(false)
    val mapScreen = mutableStateOf(false)
    val permissionState = mutableStateOf(false)
    val surferRequest = mutableStateOf<SurfaceRequest?>(null)
    val capturedImageUri = mutableStateOf<List<Uri?>>(emptyList())
    val imageCaptureUseCase: ImageCapture = ImageCapture.Builder().build()

    private val cameraPreviewUseCase = Preview.Builder().build().apply {
        setSurfaceProvider { newSurfaceRequest ->
            surferRequest.value = newSurfaceRequest
        }
    }

    suspend fun bindToCamera(appContext: Context, lifecycleOwner: LifecycleOwner) {
        val processCameraProvider = ProcessCameraProvider.awaitInstance(appContext)
        processCameraProvider.bindToLifecycle(
            lifecycleOwner, DEFAULT_BACK_CAMERA, cameraPreviewUseCase, imageCaptureUseCase
        )
        try {
            awaitCancellation()
        } finally {
            processCameraProvider.unbindAll()
        }
    }
}