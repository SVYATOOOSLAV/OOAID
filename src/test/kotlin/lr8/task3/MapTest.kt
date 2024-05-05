package lr8.task3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MapTest{
    @Test
    @DisplayName("Результат работы функции")
    fun main() {
        // Пункт 5.3
        val mapper = CustomMap()
        // Пример списка чисел.
        val numbers = listOf(0, 1, 2, 3, 4, 5)

        // Применение функции факториала.
        val factorials = mapper.map(numbers, ::factorial)
        println("Факториалы: ${factorials.joinToString(", ")}")

        // Применение функции косинуса.
        val angles = listOf(0.0, Math.PI / 4, Math.PI / 2, Math.PI)
        val cosines = mapper.map(angles, Math::cos)
        println("Косинусы: ${cosines.joinToString(", ")}")

        // Применение функции округления вверх.
        val floats = listOf(1.2, 2.5, 3.1, 4.8)
        val ceiled = mapper.map(floats, Math::ceil)
        println("Округление вверх: ${ceiled.joinToString(", ")}")
    }

    private fun factorial(n: Int): Int {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }
}