package leetcode

fun main() {
    val array = intArrayOf(4,1,2,1,2)
    println(stupidSolutionSingleOne(array))
    println(singleNumber(array))
}

/**
 * XOR operator is the best solution
 * [4,1,2,1,2]
 * 4 - 100
   1 - 001
   2 - 010
   1 - 001
   2 - 010
   -------
   x = 100 = 4!
 */
fun singleNumber(nums: IntArray): Int {
    var xor = 0
    nums.forEach {
        xor = xor.xor(it)
    }
    return xor
}

/**
 * Сумма всех элементов = 2 * (сумма уникальных элементов)
 * 2 * (сумма уникальных элементов) - сумма всех элементов = пропущенное число
 */
private fun singleNumberMath(nums: IntArray): Int {
    TODO()
}

// Time complexity O(nlogn), Space complexity O(1)
private fun sortSolution(nums: IntArray): Int {
    nums.sort() // O(nlogn)
    for (i in 1..nums.size-1) {
        if (nums[i] != nums[i-1]) {
            return nums[i]
        }
    }
    return -1
}

// Time complexity O(2n), Space complexity O(n)
private fun stupidSolutionSingleOne(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    nums.forEach { number ->
        if (!map.containsKey(number)) {
            map[number] = 1
        } else {
            map[number] = map.getValue(number) + 1
        }
    }
    map.forEach { (key, value) ->
        if (value == 1) {
            return key
        }
    }
    return nums[0]
}
