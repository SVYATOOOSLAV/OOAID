package lr8.task2

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FoldRightTest {
    @Test
    @DisplayName("Результат работы алгоритма")
    fun main() {
        // Пример использования
        val numbers = listOf(1, 2, 3, 4, 5)

        // Сумма всех элементов (справа налево)
        val sum = foldRight(numbers) { x, y -> x + y }
        println("Сумма: $sum")

        // Конкатенация строк (справа налево)
        val words = listOf("!", "Svyat", " ", "Hello")
        val result = foldRight(words) { x, y -> x + y }
        println("Конкатенация строк: $result")
    }
}