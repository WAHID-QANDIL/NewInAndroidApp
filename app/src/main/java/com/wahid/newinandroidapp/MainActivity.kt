package com.wahid.newinandroidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wahid.newinandroidapp.domain.usecase.GetMoviesUseCase
import com.wahid.newinandroidapp.presentation.screens.home.HomeScreen
import com.wahid.newinandroidapp.presentation.screens.home.HomeViewModel
import com.wahid.newinandroidapp.ui.theme.NewInAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var getMoviesUseCase: GetMoviesUseCase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewInAndroidAppTheme {

                val vm = hiltViewModel<HomeViewModel>()

                HomeScreen(viewModel = vm)
            }
        }
    }
}