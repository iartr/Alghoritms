package leetcode

// https://leetcode.com/problems/climbing-stairs/
fun main() {
    println(climbStairs(5)) // 10
    println(climbStairs(4)) // 6
    println(climbStairs(3)) // 3
    println(climbStairs(1)) // 1
}

fun climbStairs(n: Int): Int {
    var res = 0

    for (i in 0 until n) {
        if (i + 1 <= n) {
            res++
        }
        if (i + 2 <= n) {
            res++
        }
    }

    return res
}
