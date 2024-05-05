package lr3

interface QueueLr3 {
    fun enqueue(value: Int)
    fun dequeue() : Int
}