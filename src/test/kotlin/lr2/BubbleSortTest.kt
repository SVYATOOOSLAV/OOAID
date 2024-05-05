package lr2

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException
import java.util.stream.Stream
import kotlin.test.assertEquals

class BubbleSortTest {
    companion object{
        @JvmStatic
        fun provideTestCasesForTask() : Stream<Arguments>{
            return Stream.of(
                Arguments.of(arrayOf(4,32,22), arrayOf(4,22,32)),
                Arguments.of(arrayOf(324,123,5444), arrayOf(123,324,5444)),
                Arguments.of(arrayOf(9,9,8), arrayOf(8,9,9))
            )
        }
    }
    @ParameterizedTest
    @MethodSource("provideTestCasesForTask")
    fun simpleTest(testCase: Array<Int>, referent: Array<Int>){
        assertArrayEquals(referent, BubbleSort.bubbleSort(testCase))
    }

    @Test
    fun errorTest(){
        val testCase : Array<Int> = arrayOf()
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            BubbleSort.bubbleSort(testCase)
        }
        assertEquals("Array was empty", exception.message)
    }
}