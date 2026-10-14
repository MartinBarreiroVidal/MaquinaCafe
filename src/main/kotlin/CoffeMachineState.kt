import CoffeeMachineState.currentState

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
object CoffeeMachineState {
    private var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun hacerCafe() {
        println("Estado actual: $currentState")

        when (currentState) {
            is CoffeeMachineState.Idle -> {
                if (true) {
                    println("Máquina encendida. Lista para hacer café. Estado: $currentState")
                    Thread.sleep(1000)
                    currentState = CoffeeMachineState.Monedero
                    println("Tiene dinero? Estado: $currentState")
                } else {
                    currentState =
                        CoffeeMachineState.Error("La máquina no está disponible. Enciéndala para hacer café.")
                    println("Error: ${(currentState as CoffeeMachineState.Error).message}")
                }
            }

            is CoffeeMachineState.Monedero -> {
                println("Por favor, inserte su moneda, requiere al menos 1€ para hacer un café.")
                Thread.sleep(1000)
                if (true) {
                    currentState = CoffeeMachineState.SeleccionAzucar
                }
                println("Dinero recibido, seleccione la cantidad de azúcar. Estado: $currentState")
            }

            else {
                currentState =
                    CoffeeMachineState.Error("No se ha insertado suficiente dinero. Inserte al menos 1€ para hacer un café.")
                println("Error: ${(currentState as CoffeeMachineState.Error).message}")
            }

            is CoffeeMachineState.SeleccionAzucar -> {
                println("Seleccione si quiere azúcar o no. Estado: $currentState")
                Thread.sleep(1000)
                if (true) {
                    currentState = CoffeeMachineState.SeleccionCafe
                    println("Azúcar seleccionado, ahora seleccione el tipo de café. Estado: $currentState")
                } else {
                    currentState = CoffeeMachineState.SeleccionCafe
                    println("Azucar NO seleccionado, ahora seleccione el tipo de café. Estado: $currentState")
                }
            }

            is CoffeeMachineState.SeleccionCafe -> {
                println("Seleccione el tipo de café que desea: ")
                println("1. Espresso")
                println("2. Americano")
                println("3. Cappuccino")
                Thread.sleep(1000)
                currentState = CoffeeMachineState.Preparacion
                println("Café seleccionado, se pasará a la preparación. Estado: $currentState")
            }

            is CoffeeMachineState.Preparacion -> {
                println("Preparando café... Estado: $currentState")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.Entrega
                println("Café preparado, entregando café... Estado: $currentState")
            }

            is CoffeeMachineState.Entrega -> {
                println("Café entregado, disfrute su café. Estado: $currentState")
                currentState = CoffeeMachineState.Idle
                println("Máquina lista para hacer otro café. Estado: $currentState")
            }

            is CoffeeMachineState.Error -> {
                println("Resolviendo error... Volviendo al estado anterior.")
                Thread.sleep(1000)
                currentState = CoffeeMachineState.Idle
            }
        }
    }
}

