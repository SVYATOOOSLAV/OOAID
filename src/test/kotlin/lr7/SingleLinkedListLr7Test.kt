package lr7

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.Serializable
import java.nio.file.Paths

class SingleLinkedListLr7Test {

    @Test
    fun testSerialization() {
        val list = SingleLinkedListLr7<Int>()
        list.enqueue(1)
        list.enqueue(2)
        list.enqueue(3)

        val fileName = Paths.get("src","test","resources","lr7","serializedListInt.ser").toString()
        ObjectOutputStream(FileOutputStream(fileName)).use { outputStream ->
            outputStream.writeObject(list)
        }

        val deserializedList = ObjectInputStream(FileInputStream(fileName)).use { inputStream ->
            inputStream.readObject() as SingleLinkedListLr7<Int>
        }

        assertEquals(3, deserializedList.getSize())
        assertEquals(1, deserializedList.dequeue())
        assertEquals(2, deserializedList.dequeue())
        assertEquals(3, deserializedList.dequeue())
    }

    @Test
    fun testEmptyListSerialization() {
        val emptyList = SingleLinkedListLr7<String>()

        val fileName = Paths.get("src","test","resources","lr7","serializedEmptyList.ser").toString()
        ObjectOutputStream(FileOutputStream(fileName)).use { outputStream ->
            outputStream.writeObject(emptyList)
        }

        val deserializedEmptyList = ObjectInputStream(FileInputStream(fileName)).use { inputStream ->
            inputStream.readObject() as SingleLinkedListLr7<String>
        }

        assertTrue(deserializedEmptyList.isEmpty())
    }

    data class Person(val name: String, val age: Int) : Serializable
    @Test
    fun testCustomObjectSerialization() {
        val personList = SingleLinkedListLr7<Person>()
        personList.enqueue(Person("Alice", 30))
        personList.enqueue(Person("Bob", 25))
        personList.enqueue(Person("Charlie", 35))

        val fileName = Paths.get("src","test","resources","lr7","serializedCustomObjectList.ser").toString()
        ObjectOutputStream(FileOutputStream(fileName)).use { outputStream ->
            outputStream.writeObject(personList)
        }

        val deserializedPersonList = ObjectInputStream(FileInputStream(fileName)).use { inputStream ->
            inputStream.readObject() as SingleLinkedListLr7<Person>
        }

        assertEquals(3, deserializedPersonList.getSize())
        assertEquals(Person("Alice", 30), deserializedPersonList.dequeue())
        assertEquals(Person("Bob", 25), deserializedPersonList.dequeue())
        assertEquals(Person("Charlie", 35), deserializedPersonList.dequeue())
    }

    @Test
    fun testSerializationString() {
        val list = SingleLinkedListLr7<String>()
        list.enqueue("apple")
        list.enqueue("banana")
        list.enqueue("orange")

        val fileName =  Paths.get("src","test","resources","lr7","serializedListString.ser").toString()
        ObjectOutputStream(FileOutputStream(fileName)).use { outputStream ->
            outputStream.writeObject(list)
        }

        val deserializedList = ObjectInputStream(FileInputStream(fileName)).use { inputStream ->
            inputStream.readObject() as SingleLinkedListLr7<String>
        }

        assertEquals(3, deserializedList.getSize())
        assertEquals("apple", deserializedList.dequeue())
        assertEquals("banana", deserializedList.dequeue())
        assertEquals("orange", deserializedList.dequeue())
    }
}