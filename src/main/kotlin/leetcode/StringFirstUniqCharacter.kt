package leetcode

// https://leetcode.com/problems/first-unique-character-in-a-string
fun main() {
    println(firstUniqChar("leetcode"))
    println(firstUniqChar("loveleetcode"))
    println(firstUniqChar("aabb"))
}

// Time complexity : \mathcal{O}(N)O(N) since we go through the string of length N two times.
// Space complexity : \mathcal{O}(1)O(1) because English alphabet contains 26 letters.
fun firstUniqChar(s: String): Int {
    val isUniqMap = mutableMapOf<Char, Boolean>()
    s.forEachIndexed { index, c ->
        isUniqMap[c] = !isUniqMap.containsKey(c)
    }

    var minIndex = s.length
    isUniqMap.forEach { (char, isUniq) ->
        if (!isUniq) {
            return@forEach
        }
        if (s.indexOf(char) < minIndex) {
            minIndex = s.indexOf(char)
        }
    }

    return if (minIndex == s.length) {
        -1
    } else {
        minIndex
    }
}
