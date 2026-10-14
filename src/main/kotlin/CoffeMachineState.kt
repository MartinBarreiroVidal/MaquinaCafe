package org.example

//Pondreé todos los estados de la máquina de café que según yo deberían de existir en el proceso.
// Todo basado en el diagrama.

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()
    object Monedero : CoffeeMachineState()
    object SeleccionAzucar : CoffeeMachineState()
    object SeleccionCafe : CoffeeMachineState()
    object Preparacion : CoffeeMachineState()
    object Entrega : CoffeeMachineState()
    data class Error(var message: String) : CoffeeMachineState()
}