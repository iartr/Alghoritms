fun main() {
    println(search("you"))
}

private fun search(name: String): User? {
    val searchQueue = java.util.ArrayDeque<User>()
    val searched = hashSetOf<User>()
    val seller = User("peggy", true)
    val graph = mapOf<User, List<User>>(
        User("you") to listOf(User("alice"), User("bob"), User("claire")),
        User("bob") to listOf(User("anuj"), seller),
        User("alice") to listOf(seller),
        User("anuj") to listOf(),
        seller to listOf(),
        User("claire") to listOf(),
        User("jonny") to listOf(),
    )

    searchQueue.addAll(graph.getValue(User(name)))

    while (searchQueue.isNotEmpty()) {
        val user = searchQueue.poll()
        if (!searched.contains(user)) {
            if (user.isSeller) {
                return user
            } else {
                searchQueue.addAll(graph.getValue(user))
                searched.add(user)
            }
        }
    }

    return null
}

private data class User(
    val name: String,
    val isSeller: Boolean = false
)
