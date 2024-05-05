package lr8.task1

import lr8.task1.Function
import lr8.task1.TrapezoidalIntegration
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.math.atan
import kotlin.math.exp
import kotlin.math.sin
import kotlin.math.sqrt

class TrapezoidalIntegrationTest{
    @Test
    @DisplayName("Результат работы алгоритма")
    fun main() {
        val integrator = TrapezoidalIntegration.create()

        val epsilon = 0.0001 // Заданная точность

        // Пример 1
        val f1: Function = { x -> atan(0.7 * x) / (x + 1.48) }
        val result1 = integrator.integrate(f1, 0.2, 0.5, epsilon)
        println("Результат интегрирования 1: $result1")

        // Пример 2
        val f2: Function = { x -> 1 / (sqrt(x) * (exp(0.9 * x) + 3)) }
        val result2 = integrator.integrate(f2, 0.5, 2.0, epsilon)
        println("Результат интегрирования 2: $result2")

        // Пример 3
        val f3: Function = { x -> exp(1 - x) / (2 + sin(1 + x * x)) }
        val result3 = integrator.integrate(f3, 0.4, 1.0, epsilon)
        println("Результат интегрирования 3: $result3")
    }
}