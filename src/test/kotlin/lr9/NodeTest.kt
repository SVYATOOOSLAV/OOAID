package lr9

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import javax.management.OperationsException

class NodeTest {

    @Test
    fun addChild_ValidChild_ChildAddedSuccessfully() {
        val root = Node("Root")
        val child = Node("Child")
        root.addChild(child)
        assertTrue(root.children.contains(child))
    }

    @Test
    fun addChild_DuplicateChild_ExceptionThrown() {
        val root = Node("Root")
        val child = Node("Child")
        root.addChild(child)
        assertThrows(OperationsException::class.java) { root.addChild(child) }
    }

    @Test
    fun removeChild_ExistingChild_ChildRemovedSuccessfully() {
        val root = Node("Root")
        val child = Node("Child")
        root.addChild(child)
        root.removeChild(child)
        assertFalse(root.children.contains(child))
    }

    @Test
    fun removeChild_NonExistingChild_ExceptionThrown() {
        val root = Node("Root")
        val child = Node("Child")
        assertThrows(OperationsException::class.java) { root.removeChild(child) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun getChild_ValidIndex_ReturnsCorrectChild(index: Int) {
        val root = Node("Root")
        val child1 = Node("Child1")
        val child2 = Node("Child2")
        val child3 = Node("Child3")
        root.addChild(child1)
        root.addChild(child2)
        root.addChild(child3)
        assertEquals("Child${index + 1}", (root.getChild(index) as Node).name)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 3])
    fun getChild_InvalidIndex_ThrowsException(index: Int) {
        val root = Node("Root")
        assertThrows(IndexOutOfBoundsException::class.java) { root.getChild(index) }
    }
}