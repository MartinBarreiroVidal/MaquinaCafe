package org.example

object CoffeeMachine {
    var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun hacerCafe(dineroIngresado: Double, azucar: Boolean, tipoCafe: CoffeeType) {

        var enProceso = true

        while (enProceso) {
            println("Estado actual: $currentState")

            when (val state = currentState) {
                CoffeeMachineState.Idle -> {
                    println("Máquina encendida. Lista para hacer café.")
                    println("")
                    currentState = CoffeeMachineState.Monedero
                }

                CoffeeMachineState.Monedero -> {
                    println("Verificando dinero ingresado ($dineroIngresado€)...")
                    println("")
                    if (dineroIngresado >= 1.0) {
                        currentState = CoffeeMachineState.SeleccionAzucar
                        println("Dinero recibido. Pasando a selección de azúcar.")
                        println("")
                    } else {
                        currentState = CoffeeMachineState.Error("No se ha insertado suficiente dinero. Inserte al menos 1€.")
                        println("")
                    }
                }

                CoffeeMachineState.SeleccionAzucar -> {
                    if (azucar) {
                        println("Azúcar SI seleccionado.")
                        println("")
                    } else {
                        println("Azúcar NO seleccionado.")
                        println("")
                    }
                    currentState = CoffeeMachineState.SeleccionCafe
                }

                CoffeeMachineState.SeleccionCafe -> {
                    println("Verificando selección de café: $tipoCafe")
                    println("")

                    currentState = CoffeeMachineState.Preparacion(tipoCafe, azucar)
                    println("Café seleccionado, se pasará a la preparación.")
                    println("")
                }

                is CoffeeMachineState.Preparacion -> {
                    println("Preparando café (${state.tipoCafe})...")
                    println("")
                    currentState = CoffeeMachineState.Entrega
                }

                CoffeeMachineState.Entrega -> {
                    println("Café entregado, disfrute su café.")
                    println("")
                    currentState = CoffeeMachineState.Idle
                    enProceso = false
                }

                is CoffeeMachineState.Error -> {
                    println("Error: ${state.message}")
                    println("")
                    println("Resolviendo error... Volviendo al estado inicial.")
                    println("")
                    currentState = CoffeeMachineState.Idle
                    enProceso = false
                }
            }
        }
    }
}
