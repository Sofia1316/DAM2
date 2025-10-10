class Profesor constructor(nombre: String, edad: Int) {
    var nombre: String = nombre
    var edad: Int = edad

    @Override
    fun toString(nombre: String, edad: Int): String {
        return "Nombre: " + nombre + "Edad: " + edad
    }

    fun imprimirDatosProfe() {
        println(toString())
    }
}

