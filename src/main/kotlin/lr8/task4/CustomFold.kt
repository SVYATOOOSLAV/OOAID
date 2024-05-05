package lr8.task4

class CustomFold {
    fun <TElement, TAccumulator> fold(
        elements: List<TElement>,
        initial: TAccumulator,
        folderFunction: (TAccumulator, TElement) -> TAccumulator
    ): TAccumulator {
        var accumulator = initial

        for (element in elements) {
            accumulator = folderFunction(accumulator, element)
        }

        return accumulator
    }
}