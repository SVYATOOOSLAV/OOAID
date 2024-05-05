package lr3

import java.lang.Exception

class SingleLinkedListLr3 : QueueLr3 {
    private var size: Int = 0
    private var first: Node? = null
    private var last: Node? = null

    fun getFirst() = first
    fun getLast() = last
    fun getSize() = size

    override fun enqueue(value: Int) {
        val node: Node = Node(value)
        if (last == null) {
            first = node
            last = node
        } else {
            last?.next = node
            last = node
        }
        size++
    }

    override fun dequeue(): Int {
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
}

data class Node(var value: Int, var next: Node? = null) {}