fun main() {
    println(factorial(5))
}

private fun factorial(x: Int): Int {
    if (x == 1) {
        return 1
    }
    return x * factorial(x - 1)
}
