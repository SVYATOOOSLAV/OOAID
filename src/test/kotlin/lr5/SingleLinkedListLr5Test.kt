package lr5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SingleLinkedListLr5Test {
    private val testCase = SingleLinkedListLr5<Int>()

    @BeforeEach
    fun createList(){
        testCase.enqueue(1)
        testCase.enqueue(2)
        testCase.enqueue(3)
    }

    @Test
    fun iteratorTest() {
        val iterator: Iterator<Int> = testCase.iterator()
        val referent = listOf(1, 2, 3)

        var index = 0
        var cntEl = 0
        while (iterator.hasNext()) {
            if (iterator.next() == referent[index++]) {
                cntEl++
            }
        }
        assertEquals(referent.size, cntEl)
    }

    @Test
    fun cloneTest(){
        val clone = testCase.clone()

        val list = arrayListOf<Int>()

        for(el in testCase){
            list.add(el)
        }

        var index = 0
        var flag = true
        for(el in clone){
            if(el != list[index++]){
                flag = false
            }
        }

        assertTrue(flag)
    }
}