package leetcode

import leetcode.base.TreeNode

// TODO: сделать по BFS
// TODO: императивно, добавлять в List, проверять что отсортировано

// https://leetcode.com/problems/validate-binary-search-tree/
fun main() {
    val tree1 = TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }
    val tree2 = TreeNode(5).apply {
        left = TreeNode(1)
        right = TreeNode(6).apply {
            left = TreeNode(3)
            right = TreeNode(8)
        }
    }
    println(isValidBST(tree1))
    println(isValidBST(tree2))
    println(isValidBST(TreeNode(5)))
}

fun isValidBST(root: TreeNode?): Boolean {
    return isValidBSTInternal(root, Int.MIN_VALUE, Int.MAX_VALUE)
}

// Первый способ: сохраняем максимальное и минимальное значение на основе родителя, подойдет любой алгоритм
private fun isValidBSTInternal(root: TreeNode?, min: Int, max: Int): Boolean {
    if (root == null) {
        return true
    }
    if (root.value <= min || root.value >= max) {
        return false
    }
    return isValidBSTInternal(root.left, min, root.value) && isValidBSTInternal(root.right, root.value, max)
}
