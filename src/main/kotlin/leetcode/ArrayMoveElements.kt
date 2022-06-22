@file:Suppress("NAME_SHADOWING")

package leetcode

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val nums2 = intArrayOf(-1, -100, 3, 99)
    rotate2(nums1, 3)
    rotate2(nums2, 2)

    println(nums1.toList())
    println(nums2.toList())
}

// Тупое решение: просто делаем копию массива и берем нужные элементы.
// Время: O(2n). Память: O(2*n)
private fun rotate(nums: IntArray, k: Int): Unit {
    if (k == 0 || k == nums.size) {
        return
    }

    if (nums.size < 2) {
        return
    }

    val copy = nums.copyOf()
    for (i in nums.indices) {
        nums[(i + k) % nums.size] = copy[i]
    }
}

// nums => [1, 2, 3, | 4, 5, 6, 7], k = 3
// nums => [7, 6, 5, | 4, 3, 2, 1] reversed
// nums => [5, 6, 7, | 1, 2, 3, 4] reversed sperate by index k = 3
private fun rotate2(nums: IntArray, k: Int) {
    val k = k % nums.size

    val reverseArray: (array: IntArray, start: Int, end: Int) -> IntArray = { array, start, end ->
        var start = start
        var end = end

        var tmp = 0
        while (start < end) {
            tmp = array[start]
            array[start] = array[end]
            array[end] = tmp

            start++
            end--
        }
        array
    }

    reverseArray(nums, 0, nums.size - 1)
    reverseArray(nums, 0, k - 1)
    reverseArray(nums, k, nums.size - 1)
}
