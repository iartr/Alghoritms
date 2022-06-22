package leetcode

// TODO: Другие решения!

// https://leetcode.com/problems/power-of-three/solution/
fun main() {
    println("0? ${isPowerOfThree(0)}")
    println("1? ${isPowerOfThree(1)}")
    println("9? ${isPowerOfThree(9)}")
    println("4? ${isPowerOfThree(4)}")
    println("27? ${isPowerOfThree(27)}")
    println("28? ${isPowerOfThree(28)}")
}

// Используем математику. Чтобы определить, является ли число степенью N,
// нужно перевести это число в N-ую степень и проверить, что число имеет паттерн "10*0"
fun isPowerOfThree(n: Int): Boolean {
    val base3 = n.toString(3)
    return base3.matches(Regex("^10*$"))
}

// 1, 3, 9, 27, ...
// O(n)
fun isPowerOfThreeIteratively(n: Int): Boolean {
    if (n < 1) {
        return false
    }

    var n = n
    while (n % 3 == 0) {
        n /= 3
    }

    return n == 1
}
