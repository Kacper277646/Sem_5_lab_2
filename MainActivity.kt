package com.example.laby2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.laby2.ui.theme.Laby2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingApp()
        }
    }
}

@Composable
fun GreetingApp() {


    var name by remember { mutableStateOf("") }
    var output by remember { mutableStateOf("") }
    var showImage by remember {mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Wpisz imię") },
            modifier = Modifier.padding(bottom = 16.dp)

        )


        Button(
            onClick = {
                output = "Będziesz bogaty $name!"
                showImage = true
            }
        ) {
            Text("Przepowiednia!")
        }
        if (showImage){
            Image(
                painter = painterResource(id = R.drawable.revenue_2654600),
                contentDescription = "Image"
            )
        }


        Text(
            text = output,
            modifier = Modifier.padding(top = 24.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingApp() {
    Laby2Theme {
        GreetingApp()
    }
}
