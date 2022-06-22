package leetcode

// TODO: разобраться

// https://leetcode.com/problems/reverse-linked-list/
fun main() {
    val node = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3) }.apply { next = ListNode(4) }.apply { next = ListNode(5) } }
    println(node)
    println(
        reverseList(
            ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3) }.apply { next = ListNode(4) }.apply { next = ListNode(5) } }
        )
    )
}

fun reverseList(head: ListNode?): ListNode? {
    var newHead: ListNode? = null
    var head = head
    while (head != null) {
        val temp = head.next
        head.next = newHead
        newHead = head
        head = temp
    }

    return newHead
}

fun reverseRecursive(head: ListNode?): ListNode? {
    return reverseRecursiveImpl(head, null)
}

private fun reverseRecursiveImpl(head: ListNode?, newHead: ListNode?): ListNode? {
    if (head == null) {
        return newHead
    }
    val next = head.next
    head.next = newHead
    return reverseRecursiveImpl(next, head)
}
