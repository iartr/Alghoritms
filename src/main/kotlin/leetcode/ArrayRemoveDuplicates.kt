package leetcode

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var k = 0
    for (i in 1 until nums.size) {
        if (nums[k] != nums[i]) {
            k++
            nums[k] = nums[i]
        }
    }

    return k + 1
}
