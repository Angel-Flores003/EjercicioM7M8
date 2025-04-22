package cat.itb.m78.exercices.Ejemplo

import android.content.ContentValues
import android.content.Context
import android.icu.util.Output
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.camera.core.CameraSelector.DEFAULT_BACK_CAMERA
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.core.SurfaceRequest
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.lifecycle.awaitInstance
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import coil3.compose.AsyncImage
import kotlinx.coroutines.awaitCancellation

// Ej 2
//class CameraViewModel() : ViewModel() {
//    val surferRequest = mutableStateOf<SurfaceRequest?>(null)
//    private val cameraPreviewUseCase = Preview.Builder().build().apply {
//        setSurfaceProvider { newSurfaceRequest ->
//            surferRequest.value = newSurfaceRequest
//        }
//    }
//    val imageCaptureUseCase: ImageCapture = ImageCapture.Builder().build()
//    suspend fun bindToCamera(appContext: Context, lifecycleOwner: LifecycleOwner) {
//        val processCameraProvider = ProcessCameraProvider.awaitInstance(appContext)
//        processCameraProvider.bindToLifecycle(
//            lifecycleOwner, DEFAULT_BACK_CAMERA, cameraPreviewUseCase, imageCaptureUseCase
//        )
//        try {
//            awaitCancellation()
//        } finally {
//            processCameraProvider.unbindAll()
//        }
//    }
//}

// Ej 3
//class CameraViewModel : ViewModel() {
//    val surferRequest = mutableStateOf<SurfaceRequest?>(null)
//    val capturedImageUri = mutableStateOf<Uri?>(null) // <- NUEVO
//
//    private val cameraPreviewUseCase = Preview.Builder().build().apply {
//        setSurfaceProvider { newSurfaceRequest ->
//            surferRequest.value = newSurfaceRequest
//        }
//    }
//
//    val imageCaptureUseCase: ImageCapture = ImageCapture.Builder().build()
//
//    suspend fun bindToCamera(appContext: Context, lifecycleOwner: LifecycleOwner) {
//        val processCameraProvider = ProcessCameraProvider.awaitInstance(appContext)
//        processCameraProvider.bindToLifecycle(
//            lifecycleOwner, DEFAULT_BACK_CAMERA, cameraPreviewUseCase, imageCaptureUseCase
//        )
//        try {
//            awaitCancellation()
//        } finally {
//            processCameraProvider.unbindAll()
//        }
//    }
//}

// Ej 4
class CameraViewModel : ViewModel() {
    val surferRequest = mutableStateOf<SurfaceRequest?>(null)
    val capturedImageUri = mutableStateOf<Uri?>(null) // <- NUEVO

    private val cameraPreviewUseCase = Preview.Builder().build().apply {
        setSurfaceProvider { newSurfaceRequest ->
            surferRequest.value = newSurfaceRequest
        }
    }

    val imageCaptureUseCase: ImageCapture = ImageCapture.Builder().build()

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

// Ej 2
//fun takePhoto(context: Context, imageCaptureUseCase: ImageCapture) {
//    val name = "photo_" + System.nanoTime()
//    val contentValues = ContentValues().apply {
//        put(MediaStore.MediaColumns.DISPLAY_NAME, name)
//        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
//            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
//        }
//    }
//    val outputOptions = ImageCapture.OutputFileOptions.Builder(
//        context.contentResolver,
//        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//        contentValues
//    ).build()
//    imageCaptureUseCase.takePicture(
//        outputOptions,
//        ContextCompat.getMainExecutor(context),
//        object : ImageCapture.OnImageSavedCallback {
//            override fun onError(exc: ImageCaptureException) {
//                Log.e("CameraPreview", "Photo capture failed: ${exc.message}", exc)
//            }
//
//            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
//                Log.d("CameraPreview", "Photo capture succeeded: ${output.savedUri}")
//            }
//        }
//    )
//}

// Ej 3
//fun takePhoto(context: Context, imageCaptureUseCase: ImageCapture, viewModel: CameraViewModel) {
//    val name = "photo_" + System.nanoTime()
//    val contentValues = ContentValues().apply {
//        put(MediaStore.MediaColumns.DISPLAY_NAME, name)
//        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
//        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
//            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
//        }
//    }
//
//    val outputOptions = ImageCapture.OutputFileOptions.Builder(
//        context.contentResolver,
//        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//        contentValues
//    ).build()
//
//    imageCaptureUseCase.takePicture(
//        outputOptions,
//        ContextCompat.getMainExecutor(context),
//        object : ImageCapture.OnImageSavedCallback {
//            override fun onError(exc: ImageCaptureException) {
//                Log.e("CameraPreview", "Photo capture failed: ${exc.message}", exc)
//            }
//
//            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
//                output.savedUri?.let { uri ->
//                    viewModel.capturedImageUri.value = uri // <-- Aquí se guarda la imagen
//                    Log.d("CameraPreview", "Photo saved to: $uri")
//                }
//            }
//        }
//    )
//}

// Ej 4
fun takePhoto(context: Context, imageCaptureUseCase: ImageCapture, viewModel: CameraViewModel) {
    val name = "photo_" + System.nanoTime()
    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, name)
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
            put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX-Image")
        }
    }

    val outputOptions = ImageCapture.OutputFileOptions.Builder(
        context.contentResolver,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        contentValues
    ).build()

    imageCaptureUseCase.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {
            override fun onError(exc: ImageCaptureException) {
                Log.e("CameraPreview", "Photo capture failed: ${exc.message}", exc)
            }

            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                output.savedUri?.let { uri ->
                    viewModel.capturedImageUri.value = uri // <-- Aquí se guarda la imagen
                    Log.d("CameraPreview", "Photo saved to: $uri")
                }
            }
        }
    )
}