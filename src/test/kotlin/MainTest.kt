package org.example

import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {

    @Test
    fun comprobarEstadoInicial() {
        assertEquals(CoffeeMachineState.Idle, CoffeeMachine.currentState)
    }

    @Test
    fun comprobarCicloCompletoCafeExitoso() {

        CoffeeMachine.hacerCafe(1.5, true, CoffeeType.ESPRESSO)

        assertEquals(CoffeeMachineState.Idle, CoffeeMachine.currentState)
    }

    @Test
    fun comprobarCicloConDineroInsuficiente() {
        CoffeeMachine.hacerCafe(0.5, false, CoffeeType.AMERICANO)

        assertEquals(CoffeeMachineState.Idle, CoffeeMachine.currentState)
    }
}