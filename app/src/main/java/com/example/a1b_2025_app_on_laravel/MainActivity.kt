package com.example.a1b_2025_app_on_laravel

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a1b_2025_app_on_laravel.ui.theme._1b_2025_App_on_LaravelTheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _1b_2025_App_on_LaravelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppAula()

                }
            }
        }
    }
}

@Composable
fun AppAula() {
var NomeValueOfTextField by remember { mutableStateOf("") }
    var EnderecoValueOfTextField by remember { mutableStateOf("") }
    var BairroValueOfTextField by remember { mutableStateOf("") }
    var CepValueOfTextField by remember { mutableStateOf("") }
    var CidadeValueOfTextField by remember { mutableStateOf("") }
    var EstadoValueOfTextField by remember { mutableStateOf("") }


//Coluna
    Column(
        Modifier
            .fillMaxSize(),

        ) {


        //Linha 01
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Text("App Aula")
        }
        Spacer(modifier = Modifier.height(16.dp))


//Linha 02
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {


            TextField(
                value = NomeValueOfTextField,
                onValueChange = { NomeValueOfTextField = it },
                label = { Text("Nome") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

//Linha 03
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {


            TextField(
                value = EnderecoValueOfTextField,
                onValueChange = { EnderecoValueOfTextField = it },
                label = { Text("Endereço") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {


            TextField(
                value = BairroValueOfTextField,
                onValueChange = { BairroValueOfTextField = it },
                label = { Text("Bairro") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {


            TextField(
                value = CepValueOfTextField,
                onValueChange = { CepValueOfTextField = it },
                label = { Text("Cep") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {


            TextField(
                value = CidadeValueOfTextField,
                onValueChange = { CidadeValueOfTextField = it },
                label = { Text("Cidade") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {


            TextField(
                value = EstadoValueOfTextField,
                onValueChange = { EstadoValueOfTextField = it },
                label = { Text("Estado") }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        //Linha 04
        Row(
            Modifier
                .fillMaxWidth(),
            Arrangement.Center
        ) {
            Column(
                Modifier
                    .fillMaxWidth(0.4f),


                ) {
                Button(onClick = {val db = Firebase.firestore
                    val user = hashMapOf(
                        "Nome" to NomeValueOfTextField,
                        "Endereco" to EnderecoValueOfTextField,
                        "Bairro" to BairroValueOfTextField,
                        "Cep" to CepValueOfTextField,
                        "Cidade" to CidadeValueOfTextField,
                        "Estado" to EstadoValueOfTextField,
                    )
                    db.collection("users")
                        .add(user)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }



                }) {
                    Text("Cadastrar")
                }
            }


            Column(
            ) {
                Button(onClick = {}) {
                    Text("Cancelar")
                }
            }
        }
    }
}

@Preview
@Composable
fun AppAulaPreview(){
    _1b_2025_App_on_LaravelTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            AppAula()
        }
    }

}