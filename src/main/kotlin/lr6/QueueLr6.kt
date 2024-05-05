package lr6

interface QueueLr6<T>: Iterable<T>, Cloneable{
    fun enqueue(value: T)
    fun dequeue() : T
}