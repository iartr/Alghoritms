package leetcode

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
fun main() {
    println(
        intersect(
            intArrayOf(1,2,2,1),
            intArrayOf(2, 2)
        ).toList()
    )
}

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return intArrayOf()
    }

    if (nums1.size == 1 && nums1.first() in nums2) {
        return intArrayOf(nums1.first())
    } else if (nums2.size == 1 && nums2.first() in nums1) {
        return intArrayOf(nums2.first())
    }

    val counter = mutableMapOf<Int, Int>()
    val res = mutableListOf<Int>()

    nums1.forEach { value ->
        counter[value] = counter.getOrDefault(value, 0) + 1
    }

    nums2.forEach {value ->
        if (counter.containsKey(value) && counter.getValue(value) > 0) {
            res.add(value)
            counter[value] = counter.getValue(value) - 1
        }
    }

    return res.toIntArray()
}
