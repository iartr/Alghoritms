package leetcode

import java.util.EmptyStackException
import java.util.Stack

// https://leetcode.com/problems/valid-parentheses/
fun main() {
    println("must be true = ${isCorrectFull("[]")}")
    println("must be false = ${isCorrectFull("[(])")}")
    println("must be true = ${isCorrectFull("{[]}()")}")
    println("must be true = ${isCorrectFull("")}")
    println("must be false = ${isCorrectFull("((")}")
    println("must be false = ${isCorrectFull("([]")}")
}

// O(n)
fun isCorrectFull(s: String): Boolean {
    val openers = listOf('(', '[', '{')
    val closers = listOf(')', ']', '}')

    val stack = Stack<Char>()

    var count = 0
    s.forEach {
        if (it in openers) {
            stack.push(it)
            count++
        } else if (it in closers) {
            val open = try {
                stack.pop()
            } catch (e: EmptyStackException) {
                return false
            }
            val openIndex = openers.indexOf(open)
            val closeIndex = closers.indexOf(it)
            if (openIndex != closeIndex) {
                return false
            } else {
                count--
            }
        }
    }

    return count == 0
}

fun isCorrectSimple(s: String): Boolean {
    var counter = 0
    val leftBracket = '('
    val rightBracket = ')'

    s.forEach {
        if (counter < 0) {
            return false
        }
        if (it == leftBracket) {
            counter++
        } else if (it == rightBracket) {
            counter--
        }
    }

    return true
}