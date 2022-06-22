
fun main() {
    val array = IntArray(9)
    array.set(0, -1)
    array.set(1, 5)
    array.set(2, 15)
    array.set(3, 30)
    array.set(4, 40)
    array.set(5, 50)
    array.set(6, 60)
    array.set(7, 65)
    array.set(8, 102)

    println(binarySearch(array, -1))
    println(binarySearch(array, -5))
}

fun binarySearch(arr: IntArray, item: Int): Int? {
    var low: Int = 0
    var high: Int = arr.size - 1

    while (low <= high) {
        var mid = (low + high) / 2
        var guess = arr.get(mid)
        if (guess == item) {
            return guess
        }
        if (guess > item) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return null
}
