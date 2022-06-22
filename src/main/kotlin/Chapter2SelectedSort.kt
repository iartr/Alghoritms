fun main() {
    val array = intArrayOf(50, 35, 15, 66, -27, 156, 1, Int.MAX_VALUE)
    println(array.selectedSort().asList())
}

private fun IntArray.selectedSort(): IntArray {
    val newArray = IntArray(size)
    for (i in indices) {
        val smallestIndex = findSmallestIndex()
        newArray[i] = get(smallestIndex)
        this[smallestIndex] = Int.MAX_VALUE
    }
    return newArray
}

private fun IntArray.findSmallestIndex(): Int {
    var smallest = get(0)
    var smallestIndex = 0
    for (i in 1 until size) {
        if (get(i) < smallest) {
            smallest = get(i)
            smallestIndex = i
        }
    }
    return smallestIndex
}
