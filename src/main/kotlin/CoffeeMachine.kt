package org.example

object CoffeeMachine {
    private var currentState: CoffeeMachineState = CoffeeMachineState.Idle

    fun hacerCafe(dineroIngresado: Double, azucar: Boolean, tipoCafe: CoffeeType) {

        var enProceso = true

        while (enProceso) {
            println("Estado actual: $currentState")

            when (val state = currentState) {
                CoffeeMachineState.Idle -> {
                    println("Máquina encendida. Lista para hacer café.")
                    Thread.sleep(2000)
                    currentState = CoffeeMachineState.Monedero
                }

                CoffeeMachineState.Monedero -> {
                    println("Verificando dinero ingresado ($dineroIngresado€)...")
                    Thread.sleep(2000)
                    if (dineroIngresado >= 1.0) {
                        currentState = CoffeeMachineState.SeleccionAzucar
                        println("Dinero recibido. Pasando a selección de azúcar.")
                    } else {
                        currentState = CoffeeMachineState.Error("No se ha insertado suficiente dinero. Inserte al menos 1€.")
                    }
                }

                CoffeeMachineState.SeleccionAzucar -> {
                    Thread.sleep(2000)
                    if (azucar) {
                        println("Azúcar SI seleccionado.")
                    } else {
                        println("Azúcar NO seleccionado.")
                    }
                    currentState = CoffeeMachineState.SeleccionCafe
                }

                CoffeeMachineState.SeleccionCafe -> {
                    println("Verificando selección de café: $tipoCafe")
                    Thread.sleep(2000)

                    currentState = CoffeeMachineState.Preparacion(tipoCafe, azucar)
                    println("Café seleccionado, se pasará a la preparación.")
                }

                is CoffeeMachineState.Preparacion -> {
                    println("Preparando café (${state.tipoCafe})...")
                    Thread.sleep(2000)
                    currentState = CoffeeMachineState.Entrega
                }

                CoffeeMachineState.Entrega -> {
                    println("Café entregado, disfrute su café.")
                    currentState = CoffeeMachineState.Idle
                    enProceso = false
                }

                is CoffeeMachineState.Error -> {
                    println("Error: ${state.message}")
                    println("Resolviendo error... Volviendo al estado inicial.")
                    Thread.sleep(2000)
                    currentState = CoffeeMachineState.Idle
                    enProceso = false
                }
            }
        }
    }
}
