package leetcode

fun main() {
    val s = charArrayOf('H','a')
    reverseString(s)
    println(s.toList())
}

fun reverseString(s: CharArray) {
    if (s.size < 2) {
        return
    }
    var start = 0
    var end = s.size-1

    while (start < end) {
        val tmp = s[start]
        s[start] = s[end]
        s[end] = tmp
        start++
        end--
    }
}
