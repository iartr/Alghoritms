package leetcode

import leetcode.base.TreeNode

fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val left = maxDepth(root.left)
    val right = maxDepth(root.right)

    if (left > right) {
        return left + 1
    } else {
        return right + 1
    }
}
