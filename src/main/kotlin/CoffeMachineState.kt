//Pondreé todos los estados de la máquina de café que según yo deberían de existir en el proceso.
// Todo basado en el diagrama.

sealed class CoffeeMachineState {
    object Idle : CoffeeMachineState()
    object Monedero : CoffeeMachineState()
    object SeleccionAzucar : CoffeeMachineState()
    object SeleccionCafe : CoffeeMachineState()
    object Preparacion : CoffeeMachineState()
    object Entrega : CoffeeMachineState()
    data class Error(val message: String) : CoffeeMachineState()
}

fun makeCoffe () {
    println("Estado actual: $currentState")

    when (currentState) {
        is CoffeeMachineState.Idle -> {
            println("La máquina no está disponible. Espere a su disponiblidad...")
        }
        is CoffeeMachineState.Monedero -> {
            println("Por favor, inserte su moneda, se requiere al menos 1€ para hacer un café.")
        }
        is CoffeeMachineState.SeleccionAzucar -> {
            println("Por favor, seleccione si quiere azúcar.")
        }
        is CoffeeMachineState.SeleccionCafe -> {
            println("Por favor, seleccione el tipo de café que desea.")
        }
        is CoffeeMachineState.Preparacion -> {
            println("Su café se está preparando. Por favor, espere...")
        }
        is CoffeeMachineState.Entrega -> {
            println("Su café está listo. Por favor, recoja su café.")
        }
        is CoffeeMachineState.Error -> {
            println("La máquina tiene un error: ${(currentState as CoffeeMachineState.Error).message
    }
}