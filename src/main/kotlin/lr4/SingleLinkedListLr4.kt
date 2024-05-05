package lr4

import java.lang.Exception

class SingleLinkedListLr4<T> : QueueLr4<T>{
    var size: Int = 0
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    override fun enqueue(value: T) {
        val node: Node<T> = Node<T>(value)
        if(last == null){
            first = node
            last = node
        }
        else{
            last?.next = node
            last = node
        }
        size++
    }

    override fun dequeue(): T {
        val temp = first
        if(size == 1){
            first = null
            last = null
            size--
            return temp!!.value
        }
        if(size > 1){
            first = first?.next
            temp?.next = null
            size--
            return temp!!.value
        }
        else{
            throw Exception("Try to get value from empty queue")
        }
    }
}

data class Node<T>(var value: T, var next: Node<T>? = null){}