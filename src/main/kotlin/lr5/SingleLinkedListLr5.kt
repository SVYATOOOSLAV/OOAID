package lr5

import java.lang.Exception
import java.util.*

class SingleLinkedListLr5<T> : QueueLr5<T> {
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

    public override fun clone(): SingleLinkedListLr5<T> {
        val newList = SingleLinkedListLr5<T>()
        val iterator = iterator()
        while (iterator.hasNext()) {
            newList.enqueue(iterator.next())
        }
        return newList
    }
}

data class Node<T>(var value: T, var next: Node<T>? = null) {}

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
