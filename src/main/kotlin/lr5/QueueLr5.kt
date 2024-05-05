package lr5

interface QueueLr5<T>: Iterable<T>, Cloneable{
    fun enqueue(value: T)
    fun dequeue() : T
}