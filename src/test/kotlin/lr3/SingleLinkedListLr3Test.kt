package lr3

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SingleLinkedListLr3Test{
    private val list: QueueLr3 = SingleLinkedListLr3()

    @BeforeEach
    fun init(){
        list.enqueue(1)
        list.enqueue(2)
        list.enqueue(3)
    }

    @Test
    @DisplayName("ExceptionTest")
    fun exceptionTest(){
        val list = SingleLinkedListLr3()
        val exception = assertThrows(Exception::class.java) {
            list.dequeue()
        }
        assertEquals("Try to get value from empty queue", exception.message)
    }

    @Test
    @DisplayName("SizeListAfterEnqueueTest")
    fun enqueueTest(){
        val referentSize = 0
        var actualSize = 3
        for(i in 0 until actualSize){
            list.dequeue()
            actualSize--
        }
        assertEquals(referentSize, actualSize)
    }

    @Test
    @DisplayName("ElementsAfterEnqueue")
    fun enqueueElementsTest(){
        val referent = listOf(1,2,3)
        var flag = true
        for(i in 0 until referent.size - 1){
            if(list.dequeue() != referent[i]){
                flag = false
                break
            }
        }
        assertTrue(flag)
    }

    @Test
    @DisplayName("ElementsInListTest")
    fun dequeueTest(){
        val referentList = listOf(1,2,3)
        var flag = true
        for(element in referentList){
            if(list.dequeue() != element){
                flag = false
                break
            }
        }
        assertTrue(flag)
    }

    @Test
    @DisplayName("FirstElementTest")
    fun firstElementTest(){
        val testCase = SingleLinkedListLr3()
        testCase.enqueue(1)
        testCase.enqueue(2)
        testCase.enqueue(3)
        assertEquals(1, testCase.getFirst()?.value)
    }

    @Test
    @DisplayName("LastElementTest")
    fun lastElementTest(){
        val testCase = SingleLinkedListLr3()
        testCase.enqueue(1)
        testCase.enqueue(2)
        testCase.enqueue(3)
        assertEquals(3, testCase.getLast()?.value)
    }

    @Test
    @DisplayName("SizeTest")
    fun sizeTest(){
        val testCase = SingleLinkedListLr3()
        testCase.enqueue(1)
        testCase.enqueue(2)
        testCase.enqueue(3)
        assertEquals(3, testCase.getSize())
    }
}