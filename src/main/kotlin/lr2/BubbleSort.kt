package lr2

class BubbleSort{
    companion object{
        fun bubbleSort(arr: Array<Int>): Array<Int> {
            val n = arr.size
            if(n == 0){
                throw IllegalArgumentException("Array was empty")
            }
            for (i in 0 until n) {
                for (j in 0 until n - i - 1) {
                    if (arr[j] > arr[j + 1]) {
                        val temp = arr[j]
                        arr[j] = arr[j + 1]
                        arr[j + 1] = temp
                    }
                }
            }
            return arr
        }
    }
}