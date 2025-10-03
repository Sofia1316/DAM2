package com.example.hola

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
//import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hola.ui.theme.HolaTheme

//private val BlendMode.Green: Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //DosTextosVertical()
            //dispos()
            //ejemploBox()
            //ImagenConTexto2()
            imagenConZoom()
        }
    }
}
// EJEMPLO 1
@Composable // para poder interactuar con el jetpack
fun DosTextosVertical(){

    Column(modifier = Modifier.fillMaxSize().padding(top=40.dp)){
        Row(){
            Text(text = "Primer texto")
            Spacer(modifier = Modifier.width(30.dp))
            Text(text = "Segundo texto")
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Primer texto")
        Text(text = "Segundo texto")
    }
}

@Preview // para que se vea en el móvil
@Composable
fun DosTextosVerticalPreview(){
    DosTextosVertical()
}

// EJEMPLO 2
@Composable
fun dispos(){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(height = 40.dp))
        Row() {
            Text(text = "segundo texto")
            Spacer(modifier = Modifier.width(width = 20.dp))
            Text(text = "tercer texto")
        }
        Column(modifier = Modifier.fillMaxSize().padding(top = 40.dp)) {
            Text(text = "primer texto")
            Text(text = "segundo texto")
        }
    }
}

@Preview
@Composable
fun disposView(){
    dispos()
}

// EJEMPLO 3
@Composable
fun ejemploBox(){
    Box(modifier = Modifier.fillMaxSize().padding(25.dp)){
        Text("Parte Superior Izquierda", modifier = Modifier.align(Alignment.TopStart))
        Text("Parte central", modifier = Modifier.align(Alignment.Center))
        Text("Parte inferior derecha", modifier = Modifier.align(Alignment.BottomEnd))
    }
}

@Preview
@Composable
fun boxView(){
    ejemploBox()
}

// EJEMPLO 4
@Composable
fun ImagenConTexto(){
    Box(modifier = Modifier.fillMaxSize().padding(25.dp)){
        Image(
            painter = painterResource(id = R.drawable.drogon),
            contentDescription = "Dragón GOT",
            modifier = Modifier.align(Alignment.Center).fillMaxSize()
            )
        Text(text="Drogon",
            fontSize = 22.sp,
            color=Color.Green,
            textAlign = TextAlign.Center, // centrado en la línea en la que estoy escribiendo
            modifier = Modifier.align(Alignment.Center) //
            )
    }
}
@Preview
@Composable
fun drogonView(){
    ImagenConTexto()
}

// EJEMPLO 5
fun randomColor(): Color{ // para decir el parámetro de salida
    /*palabra reservada para valores que van a cambiar --> val*/
    /*palabra reservada para valores que no van a cambiar --> var*/
    val rojo = (0..255).random()
    val azul = (0..255).random()
    val verde = (0..255).random()

    return Color(rojo, azul, verde)
}

@Composable
fun ImagenConTexto2(){
    var BackgroundBoxColor by remember{ mutableStateOf(Color.White) }
    var textPosition by remember{mutableStateOf(Offset(0f,0f))} // el offset es para coordenadas X e Y
    var imagePosition by remember {mutableStateOf(Offset(0f, 0f))}
    var anchoPantalla by remember {mutableStateOf(0f)}
    var altoPantalla by remember {mutableStateOf(0f)}
    var anchoTexto by remember {mutableStateOf(0f)}
    var altoTexto by remember {mutableStateOf(0f)}

    Box(modifier = Modifier.fillMaxSize().padding(25.dp).background(BackgroundBoxColor).
    onGloballyPositioned{coordenadas ->
        anchoPantalla = coordenadas.size.width.toFloat()
        altoPantalla = coordenadas.size.height.toFloat()

        if (textPosition == Offset(0f, 0f)){
            textPosition = Offset(anchoPantalla / 2, altoPantalla / 2)
        }
    })

    {

        Image(
            painter = painterResource(id = R.drawable.drogon),
            contentDescription = "Dragón GOT",
            modifier = Modifier.offset{
                IntOffset(imagePosition.x.toInt(), imagePosition.y.toInt())
            }.pointerInput(Unit){
                detectDragGestures {
                    change, dragAmount -> change.consume()
                    imagePosition += Offset(dragAmount.x, dragAmount.y)}
            }

        )
        Text(text="Drogon siendo imponente",
            fontSize = 22.sp,
            color=Color.Green,
            textAlign = TextAlign.Center, // centrado en la línea en la que estoy escribiendo
            modifier = Modifier
                .onGloballyPositioned{
                    coordenadas ->
                    anchoTexto = coordenadas.size.width.toFloat()
                    altoTexto = coordenadas.size.height.toFloat()

                    if (textPosition == Offset(0f, 0f)) {
                        textPosition = Offset((anchoPantalla - anchoTexto) / 2, (altoPantalla - altoPantalla) / 2)
                    }
                }

                .offset{
                IntOffset(textPosition.x.toInt(),textPosition.y.toInt())
            }.pointerInput(Unit){
                detectDragGestures { change, dragAmount ->
                    change.consume() // ?
                    textPosition += Offset(dragAmount.x,dragAmount.y)} // en el eje X y en el eje Y donde acaba el texto
            }
        )
        Button(
            onClick = {BackgroundBoxColor = randomColor()},
            //modifier= Modifier.align(Alignment.TopStart)
            // La mayus es una clase y la minuscula de offset para situar algún elemento
            modifier= Modifier.align(Alignment.TopStart)
        )
        {
            Text(text="Cambiar fondo") // detrás de cada button, poner un text entre llaves
        }
    }
}
@Preview
@Composable
fun drogonView2(){
    ImagenConTexto2()
}

// EJEMPLO 6
@Preview
@Composable
fun imagenConZoom(){
    var escalaImagen by remember {mutableStateOf(1f)} // con valor mutable hay que meter un valor inicial
    var posicionImagen by remember {mutableStateOf(Offset(0f, 0f))}
    var anguloRotacion by remember{mutableStateOf(0f)}

    Box(
        modifier = Modifier.fillMaxSize().pointerInput(Unit){
            detectTransformGestures {_, desplazamiento, zoom, rotacion  ->
                escalaImagen = escalaImagen * zoom
                posicionImagen += desplazamiento
                anguloRotacion += rotacion
            }
        }.pointerInput(Unit){
            detectTapGestures (onDoubleTap = {
                // devolvemos la imagen a su estado inicial
                escalaImagen = 1f
                posicionImagen = Offset(0f, 0f)
                anguloRotacion = 0f
            })
        }
        , contentAlignment = Alignment.Center
    )

    {
        Image(
            painter = painterResource(id = R.drawable.drogon),
            contentDescription = "Drogon mirando",
            modifier = Modifier.graphicsLayer(
                scaleX = escalaImagen.coerceIn(0.5f, 3f),
                scaleY = escalaImagen.coerceIn(0.5f, 3f),
                translationX = posicionImagen.x,
                translationY = posicionImagen.y,
                rotationZ = anguloRotacion
            )
        )
    }
}


