/*
fun main(){
    println("Hola")
    val numPlanetas: Int = 8
    var planeta : String
    planeta = "Tierra"
    println("El num de planetas es de: " + numPlanetas)
    planeta = "Marte"
    println("El planeta de los aliens es " + planeta)
}*/

/*class Persona(string: String, string1: String, i: Int) {
   class Person(var nombre:String, var primerAp:String, val edad:Int = 18){
}*/
/*EJEMPLO 3
fun main(){
    print("Introduce tu peso")
    val peso = readln().toInt()
    print("Introduce la altura")
    val altura = readln().toInt()

    when{
        peso > 90 && altura < 190 -> println("Apuntate al gym")
        peso < 60 && altura > 165 -> println("Apuntate al gym")
        peso < 90 && altura < 195 -> println("Normal")
        else -> print("Eres promedio")
    }

    var dia = readln().toInt()
    when(dia){
        1 -> print("lunes")
        2 -> print("martes")
        else -> print("no es lunes ni martes")
    }*/

// EJEMPLO 2
/*val persona1 = Persona("pepito", "grillo", 24)
println(persona1)

var numero : Int = 4
var vueltas = 10
vueltas = 0

while (numero <= 25){
    println("el num es $numero")
    numero = numero + 2;
}

do{
    println(vueltas)
    vueltas--
} while (vueltas != 0)

for(i in 0..100){
    println("vuelta 1 " + i)
}

for(i in 10 downTo 1){ // de 10 a 1
    println(i)
}

for(i in 1..10 step 2){ // equivalente al i++
    println(i)
}
}
}
*/
fun main(){
    val profe1 = Profesor("pepin", 58)
    profe1.imprimirDatosProfe()

    /*print("Longitud del cuadrado")
    var lado = readln().toInt()
    println("El área del cuadrado es ${areaCuadrado(lado)}")

    datosCurso("Salesianos santo domingo savio")
    datosCurso("Perelló", "asir")

    costekm("4627462W", 4.3, 256.13)
    costekm(numkm = 228888.89, matricula = "7374626Y", costeKM = 156.13)
    costekm(numkm = 28.89, matricula = "21837124Y", costeKM = 113.0)

    var notaAlumnos : IntArray
    notaAlumnos = IntArray(4)
    for(i in 0..3){
        print("Mete números")
        notaAlumnos[i] = readln().toInt()
    }
    for(i in 0..3){
        println("***********")
        println(notaAlumnos.size)
        print(notaAlumnos[2])
    }*/
}
/*
fun areaRectangulo(alto:Int, ancho :Int) : Int {
    return alto * ancho
}

fun areaCuadrado(lado : Int) = lado * lado

fun datosCurso(centro:String, titulacion:String = "DAM"){
    println("${centro}; ${titulacion}")
}

fun costekm (matricula: String, costeKM: Double, numkm: Double){
    var costeTotal = costeKM * numkm
    println("El coste total es: " + costeTotal)
}
*/

