class Persona(string: String, string1: String, i: Int) {
    /*class Person(var nombre:String, var primerAp:String, val edad:Int = 18){

    }*/

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
        }

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
        }*/
    }
}





