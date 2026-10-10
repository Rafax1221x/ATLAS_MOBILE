package com.example.atlaspi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.atlaspi.components.Logo
import com.example.atlaspi.ui.theme.AzulPretoleo
import com.example.atlaspi.ui.theme.BegeClaro
import com.example.atlaspi.ui.theme.MarromEscuro
import com.example.atlaspi.ui.theme.TerracotaDourado
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
onNavigateBack: () -> Unit

) {

    //
    var senha by remember { (mutableStateOf( "")) }
    var email by remember { (mutableStateOf( "")) }

    //

    Column(
        modifier = Modifier.fillMaxSize().background(BegeClaro),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Logo(
            200,
            270,
            0,


            )
        Spacer(modifier = Modifier.height(20.dp))

        Card(
            colors = CardDefaults.cardColors(
                containerColor = BegeClaro
            ),
            modifier = Modifier.width((300.dp))

        ) {
            Text(
                text = "LOGIN",
                modifier = Modifier
                    .padding(bottom = 5.dp)
                    .fillMaxWidth(),
                fontFamily = FontFamily.SansSerif, //Alterar a fonte depois
                letterSpacing = 7.sp,
                fontSize = 30.sp,
                color = AzulPretoleo,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(300)

            )


            Text(
                text = "E-mail",
                modifier = Modifier,
                fontFamily = FontFamily.SansSerif, //Alterar a fonte depois
                letterSpacing = 3.sp,
                fontSize = 15.sp,
                color = MarromEscuro,
                fontWeight = FontWeight(700)
            )
            // Fiz um componente para poder reutilizar esse container
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = { Text("Digite seu e-mail") }

            )

            Text(
                text = "Senha",
                modifier = Modifier.padding(top = 10.dp),
                fontFamily = FontFamily.SansSerif, //Alterar a fonte depois
                letterSpacing = 3.sp,
                fontSize = 15.sp,
                color = MarromEscuro,
                fontWeight = FontWeight(700)
            )
            // Fiz um componente para poder reutilizar esse container
            OutlinedTextField(
                value = senha,
                onValueChange = {senha = it},
                label = { Text("Digite sua senha",) })

            Text(
                text = "Esqueceu sua senha?",
                modifier = Modifier.padding(top = 5.dp),
                textDecoration = TextDecoration.Underline,
                color = TerracotaDourado,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(20.dp))

            Column (){



                Button(onClick = {
                    if (email.isNotBlank() && senha.isNotBlank()){
                        onNavigateBack()
                    }
                },
                    enabled = email.isNotBlank() && senha.isNotBlank() ,
                    modifier = Modifier
                        .width(290.dp)
                        .height(50.dp)




                )


                { Text("Entrar") }





            }
        }
    }
}


