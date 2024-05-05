package lr4

interface QueueLr4<T> {
    fun enqueue(value: T)
    fun dequeue() : T
}