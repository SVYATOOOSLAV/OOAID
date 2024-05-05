package lr6

import lr5.SingleLinkedListLr5
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import java.util.Scanner
import java.util.stream.IntStream
import java.util.stream.Stream
import kotlin.streams.toList
import kotlin.test.assertEquals

class SingleLinkedListLr6Test {

    @ParameterizedTest
    @CsvSource("10,20", "30,40", "50,60")
    fun loopTest(first: Int, last:Int){
        val list = SingleLinkedListLr6<Int>()
        val range = IntStream.rangeClosed(first, last).toList()

        for(i in first .. last){
            list.enqueue(i)
        }

        var index = 0
        var flag = true
        for (el in list) {
            if(el != range[index++]){
                flag = false
            }
        }

        assertTrue(flag)
    }

    @ParameterizedTest
    @CsvSource("10,20", "30,40", "50,60")
    fun pipelineTest(first: Int, last:Int){
        val list = SingleLinkedListLr6<Int>()
        val range = IntStream.rangeClosed(first, last).toList()
        for(i in first .. last){
            list.enqueue(i)
        }
        var index = 0
       assertEquals(range.size,list.count { it == range[index++] })
    }

    @ParameterizedTest
    @CsvSource("-10,20", "-30,40", "-10,60", "-1,1000", "10,30")
    fun findElSmallerThanZeroAndTakeAverage(first: Int, last: Int) {
        val list = SingleLinkedListLr6<Int>()
        for (i in first..last) {
            list.enqueue(i)
        }

        val sumEl = list
            .filter { it < 0 }
            .sum().toDouble()

        val countEl = list.count { it < 0 }

        val expectedAverage = if (countEl > 0) sumEl / countEl else 0.0

        assertEquals(expectedAverage, computeAverageOfElementsSmallerThanZero(list))
    }

    private fun computeAverageOfElementsSmallerThanZero(list: SingleLinkedListLr6<Int>): Double {
        val sumEl = list
            .filter { it < 0 }
            .sum().toDouble()

        val countEl = list.count { it < 0 }

        return if (countEl > 0) sumEl / countEl else 0.0
    }
}