package lr4

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.Objects
import java.util.stream.Stream

class SingleLinkedListLr4Test {

    companion object {
        @JvmStatic
        fun provideTestCasesForTheTask(): Stream<Arguments> {
            val listInt = SingleLinkedListLr4<Int>()
            listInt.enqueue(1)
            listInt.enqueue(2)
            listInt.enqueue(3)
            val listStr = SingleLinkedListLr4<String>()
            listStr.enqueue("a")
            listStr.enqueue("b")
            listStr.enqueue("c")
            val listPer = SingleLinkedListLr4<Person>()
            listPer.enqueue(Person("Ivan", "Fedorov"))
            listPer.enqueue(Person("Petr", "Frolov"))
            listPer.enqueue(Person("Ilya", "Godin"))
            return Stream.of(
                Arguments.of(listInt, listInt.size),
                Arguments.of(listStr, listStr.size),
                Arguments.of(listPer, listPer.size)
            )
        }
    }

    @Test
    @DisplayName("ExceptionTest")
    fun exceptionTest() {
        val list = SingleLinkedListLr4<Int>()
        val exception = assertThrows(Exception::class.java) {
            list.dequeue()
        }
        assertEquals("Try to get value from empty queue", exception.message)
    }

    @ParameterizedTest
    @MethodSource("provideTestCasesForTheTask")
    @DisplayName("SizeAfterEnqueueIntTest")
    fun enqueueTest(list: SingleLinkedListLr4<Objects>, size: Int) {
        val referentSize = 3
        assertEquals(referentSize, size)
    }

    @Test
    fun dequeueIntTest() {
        val referentListInt = listOf(1, 2, 3)
        val listInt = SingleLinkedListLr4<Int>()
        listInt.enqueue(1)
        listInt.enqueue(2)
        listInt.enqueue(3)
        val flag = true
        for (element in referentListInt) {
            if (listInt.dequeue() != element) {
                !flag
            }
        }
        assertTrue(flag)
    }

    @Test
    fun dequeueStringTest() {
        val referentListString = listOf("a","b","c")
        val listStr = SingleLinkedListLr4<String>()
        listStr.enqueue("a")
        listStr.enqueue("b")
        listStr.enqueue("c")
        val flag = true
        for (element in referentListString) {
            if (listStr.dequeue() != element) {
                !flag
            }
        }
        assertTrue(flag)
    }

    @Test
    fun dequeuePersonTest() {
        val listPer = SingleLinkedListLr4<Person>()
        listPer.enqueue(Person("Ivan", "Fedorov"))
        listPer.enqueue(Person("Petr", "Frolov"))
        listPer.enqueue(Person("Ilya", "Godin"))
        val referentListPerson = listOf(
            Person("Ivan", "Fedorov"),
            Person("Petr", "Frolov"),
            Person("Ilya", "Godin"))
        val flag = true
        for (element in referentListPerson) {
            if (listPer.dequeue() != element) {
                !flag
            }
        }
        assertTrue(flag)
    }
}

data class Person(val name: String, val surname: String)