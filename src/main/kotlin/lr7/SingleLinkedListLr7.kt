package lr7

import java.io.Serializable
import java.lang.Exception

class SingleLinkedListLr7<T> : QueueLr7<T>, Serializable{
    companion object{
        const val serialVersionUID = 111L
    }
    private var size: Int = 0
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    override fun enqueue(value: T) {
        val node: Node<T> = Node<T>(value)
        if (last == null) {
            first = node
            last = node
        } else {
            last?.next = node
            last = node
        }
        size++
    }

    override fun dequeue(): T {
        val temp = first
        if (size == 1) {
            first = null
            last = null
            size--
            return temp!!.value
        }
        if (size > 1) {
            first = first?.next
            temp?.next = null
            size--
            return temp!!.value
        } else {
            throw Exception("Try to get value from empty queue")
        }
    }

    override fun iterator(): Iterator<T> {
        return IteratorImpl(first)
    }

    public override fun clone(): SingleLinkedListLr7<T> {
        val newList = SingleLinkedListLr7<T>()
        val iterator = iterator()
        while (iterator.hasNext()) {
            newList.enqueue(iterator.next())
        }
        return newList
    }

    fun getSize() : Int{
        return size
    }

    fun isEmpty() : Boolean{
        return size == 0
    }
}

data class Node<T>(var value: T, var next: Node<T>? = null) : Serializable {}

class IteratorImpl<T> (private var currentNode: Node<T>?): Iterator<T>{
    override fun hasNext(): Boolean {
        return currentNode != null
    }

    override fun next(): T {
        val value = currentNode!!.value
        currentNode = currentNode!!.next
        return value
    }
}
