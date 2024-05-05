package lr8.task1

import kotlin.math.abs

typealias Function = (Double) -> Double

class TrapezoidalIntegration private constructor() {

    companion object{
         fun create() = TrapezoidalIntegration()
    }

    fun integrate(func: Function, a: Double, b: Double, epsilon: Double): Double {
        var n = 1 // Начальное число сегментов
        var previousResult = trapezoidalRule(func, a, b, n)
        var currentResult: Double

        do {
            n *= 2 // Увеличиваем количество сегментов
            currentResult = trapezoidalRule(func, a, b, n)

            // Оценка погрешности по правилу Рунге
            val rungeError = abs(currentResult - previousResult) / 3.0

            if (rungeError <= epsilon) {
                break
            }

            previousResult = currentResult
        } while (true)

        return currentResult
    }

    private fun trapezoidalRule(func: Function, a: Double, b: Double, n: Int): Double {
        val h = (b - a) / n // Ширина шага
        var sum = 0.0
        sum += 0.5 * (func(a) + func(b))

        // Вычисляем сумму трапеций между a и b
        for (i in 1 until n) {
            val x = a + i * h
            sum += func(x)
        }

        return h * sum // Умножаем на ширину шага
    }
}