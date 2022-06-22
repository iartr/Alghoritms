package leetcode

fun main() {
    Solution().firstBadVersion(5)
}

private class Solution : VersionControl() {
    fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n
        var answ = -1
        while (left <= right) {
            val mid = left + ((left + right)/2)
            if (isBadVersion(mid)) {
                right = mid - 1
                answ = mid
            } else {
                left = mid + 1
            }
        }

        return answ
    }
}

private open class VersionControl {
    open fun isBadVersion(version: Int) : Boolean { return false }
}
