package org.example

object CoffeeMachine {
    private var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun hacerCafe() {
        println("Estado actual: $currentState")

        when (currentState) {
            CoffeeMachineState.Idle -> {
                println("Máquina encendida. Lista para hacer café. Estado: $currentState")
                Thread.sleep(1000)
                currentState = CoffeeMachineState.Monedero
                println("Tiene dinero? Estado: $currentState")
            }

            CoffeeMachineState.Monedero -> {
                println("Inserte su moneda, requiere al menos 1€ para hacer un café.")
                Thread.sleep(1000)
                if (true) {
                    currentState = CoffeeMachineState.SeleccionAzucar
                    println("Dinero recibido, seleccione la cantidad de azúcar. Estado: $currentState")
                } else {
                    currentState = CoffeeMachineState.Error("No se ha insertado suficiente dinero. Inserte al menos 1€ para hacer un café.")
                    println("Error: ${(currentState as CoffeeMachineState.Error).message}")
                }
            }

            CoffeeMachineState.SeleccionAzucar -> {
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

            CoffeeMachineState.SeleccionCafe -> {
                println("Seleccione el tipo de café que desea: ")
                println("1. Espresso")
                println("2. Americano")
                println("3. Cappuccino")
                Thread.sleep(1000)
                currentState = CoffeeMachineState.Preparacion
                println("Café seleccionado, se pasará a la preparación. Estado: $currentState")
            }

            CoffeeMachineState.Preparacion -> {
                println("Preparando café... Estado: $currentState")
                Thread.sleep(2000)
                currentState = CoffeeMachineState.Entrega
                println("Café preparado, entregando café... Estado: $currentState")
            }

            CoffeeMachineState.Entrega -> {
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