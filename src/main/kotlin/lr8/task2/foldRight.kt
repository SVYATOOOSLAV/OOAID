package lr8.task2

fun <T> foldRight(list: List<T>, func: (T, T) -> T): T {
    if (list.isEmpty()) {
        throw IllegalArgumentException("Список не должен быть пустым.")
    }

    // Начинаем с последнего элемента и идем к началу списка
    var accumulator = list.last()

    // Проходим по элементам в обратном порядке, начиная с предпоследнего
    for (i in list.size - 2 downTo 0) {
        accumulator = func(accumulator, list[i])
    }

    return accumulator
}