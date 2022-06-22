package leetcode

// https://leetcode.com/problems/climbing-stairs/
// https://youtu.be/Y0lT9Fck7qI

fun main() {
    println(climbStairs(37))
    println(climbStairs(5))
    println(climbStairs(4))
    println(climbStairs(3))
    println(climbStairs(1))
}

val cache = mutableMapOf<Int, Int>(
    0 to 1,
    1 to 1,
    2 to 2
)

// Fibonacci O(n)
fun climbStairs(n: Int): Int {
    if (cache.containsKey(n)) {
        return cache.getValue(n)
    }

    val value = climbStairs(n - 1) + climbStairs(n - 2)
    cache[n] = value
    return value
}

fun fibonacciBestSolution(n: Int): Int {
    // base cases
    if (n <= 0) return 0
    if (n == 1) return 1
    if (n == 2) return 2

    var oneStepBefore = 2
    var twoStepsBefore = 1
    var allWays = 0

    for (i in 2 until n) {
        allWays = oneStepBefore + twoStepsBefore
        twoStepsBefore = oneStepBefore
        oneStepBefore = allWays
    }
    return allWays
}
