package leetcode

/**
https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
fun main() {
    println(
        twoSumBadSolution(
            intArrayOf(2,7,11,15),
            9
        ).toList()
    )
    println(
        twoSumHashDoubleIteration(
            intArrayOf(2,7,11,15),
            9
        ).toList()
    )
    println(
        twoSumHashOneIteration(
            intArrayOf(2,7,11,15),
            9
        ).toList()
    )
}

fun twoSumHashOneIteration(nums: IntArray, target: Int): IntArray {
    val valueIndexMap = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        val difference = target - i
        if (valueIndexMap.containsKey(difference)) {
            return intArrayOf(valueIndexMap.getValue(difference), index)
        }
        valueIndexMap[i] = index
    }
    return intArrayOf()
}

fun twoSumHashDoubleIteration(nums: IntArray, target: Int): IntArray {
    val valueIndexMap = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        valueIndexMap[i] = index
    }
    nums.forEachIndexed { index, i ->
        val value = target - i
        if (valueIndexMap.containsKey(value) && valueIndexMap[value] != i) {
            return intArrayOf(index, valueIndexMap.getValue(value))
        }
    }
    return intArrayOf()
}

fun twoSumBadSolution(nums: IntArray, target: Int): IntArray {
    for (i in 0 until nums.size) {
        for (j in i until nums.size) {
            if (i != j) {
                if (nums[i] + nums[j] == target) {
                    return intArrayOf(i, j)
                }
            }
        }
    }
    return intArrayOf()
}
