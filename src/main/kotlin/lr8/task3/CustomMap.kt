package lr8.task3

class CustomMap{
    fun <Input, Output> map(inputList: List<Input>, mapFunction: (Input) -> Output): List<Output> {
        val outputList = mutableListOf<Output>()

        for (item in inputList) {
            outputList.add(mapFunction(item))
        }

        return outputList
    }
}
