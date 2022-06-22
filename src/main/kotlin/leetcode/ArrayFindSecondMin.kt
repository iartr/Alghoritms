package leetcode

// Найти ВТОРОЙ минимальный элемент
// [1, 2, 3, 4, 5, 6] --> 2
// [1, 1, 2, 3, 4] --> 1?
// Два последовательных цикла
fun main() {
    val array = intArrayOf(5, 13, 7, -1, 6, 102, 4)

    if (array.isEmpty()) {
        println()
    } else if (array.size == 1) {
        println(array.first())
    }

    var min = Int.MAX_VALUE
    var minIndex = 0
    for (i in array.indices) {
        if (array[i] < min) {
            min = array[i]
            minIndex = i
        }
    }

    min = Int.MAX_VALUE
    for (i in array.indices) {
        if (array[i] < min && i != minIndex) {
            min = array[i]
        }
    }

    println(min)
}
