package lr7

interface QueueLr7<T>: Iterable<T>, Cloneable{
    fun enqueue(value: T)
    fun dequeue() : T
}