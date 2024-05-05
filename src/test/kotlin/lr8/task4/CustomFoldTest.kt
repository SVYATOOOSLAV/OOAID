package lr8.task4

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.sqrt

typealias Function = (Double, Double) -> Double

class CustomFoldTest{
    @Test
    @DisplayName("Результат работы приложения")
    fun main() {
        // Пункт 5.4
        val folder = CustomFold()
        // Пример списка чисел.
        val numbers2 = listOf(3.0, 1.0, 4.0, 1.0, 5.0, 9.0)

        // Применение функции произведения.
        val mulFunction: Function = { acc, x -> acc * x }
        val productResult = folder.fold(numbers2, 1.0, mulFunction)
        println("Произведение элементов: $productResult")

        // Применение функции max.
        val maxFunction: Function = { x, y -> max(x, y) }
        val maxResult = folder.fold(numbers2, Double.MIN_VALUE, maxFunction)
        println("Максимальное значение: $maxResult")

        // Применение функции среднего квадратичного.
        val quadraticMeanResult = folder.fold(numbers2, 0.0, ::quadraticMean)
        println("Среднее квадратичное: $quadraticMeanResult")

    }

    private fun quadraticMean(x: Double, y: Double): Double {
        return sqrt((x * x + y * y) / 2)
    }
}