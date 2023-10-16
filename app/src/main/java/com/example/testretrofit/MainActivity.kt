package com.example.testretrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.testretrofit.ui.theme.TestRetrofitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestRetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {
    val vm = remember {
        SentenceViewModel(
            SentenceRepository(
                SentenceService(
                    RetrofitHelper.getRetrofit().create(SentenceApiClient::class.java)
                )
            )
        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        /*
        vm.sentence.value?.let {
            Text(text = it)
        }
         */
        vm.multipleSentences.let {
            if (it.isNotEmpty()) {

                Column(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    it.forEach { sentence ->
                        Text(text = sentence?.anwei ?: "error")
                    }
                }
            }
        }

        Button(
            onClick = {
                //vm.loadNextSentence()
                vm.loadSentenceOf(5)
            }
        ) {
            Text(text = "下一条")
        }
    }
}

@Preview
@Composable
fun AppPreview() {
    App()
}