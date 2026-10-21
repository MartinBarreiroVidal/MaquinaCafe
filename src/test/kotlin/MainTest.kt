import org.example.CoffeeMachine
import org.example.CoffeeType

fun main() {
    println("--- PRUEBA 1 (Todo correcto) ---")
    CoffeeMachine.hacerCafe(dineroIngresado = 1.5, azucar = false, tipoCafe = CoffeeType.AMERICANO)
    /*/
        println("--- PRUEBA 2 (Falta dinero) ---")
        CoffeeMachine.hacerCafe(dineroIngresado = 0.5, azucar = false, tipoCafe = CoffeeType.ESPRESSO)
     */
}
