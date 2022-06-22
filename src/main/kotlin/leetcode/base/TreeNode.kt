package leetcode.base

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode(value=$value, left=$left, right=$right)"
    }
}
