package leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

private fun deleteNode(node: ListNode?) {
    if (node == null) {
        return
    }

    node.`val` = node.next!!.`val`
    node.next = node.next!!.next
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return "Node { val=${`val`} next=$next}"
    }
}
