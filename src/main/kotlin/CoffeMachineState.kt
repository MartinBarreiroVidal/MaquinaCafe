package org.example

//Pondré todos los estados de la máquina de café que según yo deberían de existir en el proceso.
//Todo basado en el diagrama.


enum class CoffeeType {
    ESPRESSO,
    AMERICANO,
    CORTADO
}

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()
    object Monedero : CoffeeMachineState()
    object SeleccionAzucar : CoffeeMachineState()
    object SeleccionCafe : CoffeeMachineState()
    data class Preparacion(val tipoCafe: CoffeeType, val conAzucar: Boolean) : CoffeeMachineState()
    object Entrega : CoffeeMachineState()
    data class Error(var message: String) : CoffeeMachineState()
}
