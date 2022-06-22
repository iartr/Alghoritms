fun main () {
    val array = arrayListOf(50, 35, 15, 66, -27, 156, 1)
    println(array.quickSort())
}

private fun ArrayList<Int>.quickSort(): ArrayList<Int> {
    if (size < 2) {
        return this
    }

    val pivot = get(0)
    val (less, greater) = getLessAndGreatest(pivot, 0)

    return less.quickSort().apply {
        add(pivot)
        addAll(greater.quickSort())
    }
}

private fun ArrayList<Int>.getLessAndGreatest(pivot: Int, pivotIndex: Int): Pair<ArrayList<Int>, ArrayList<Int>> {
    val less = arrayListOf<Int>()
    val greatest = arrayListOf<Int>()
    for (i in indices) {
        if (get(i) <= pivot && i != pivotIndex) {
            less.add(get(i))
        } else if (get(i) >= pivot && i != pivotIndex) {
            greatest.add(get(i))
        }
    }
    return Pair(less, greatest)
}
