// https://github.com/casidiablo/dijkstra-kotlin/

fun main() {
    val graph = mapOf<GraphPoints, Int>(
        GraphPoints("start", "A") to 6,
        GraphPoints("start", "B") to 2,

        GraphPoints("A", "final") to 1,

        GraphPoints("B", "A") to 3,
        GraphPoints("B", "final") to 5,
    )

    val minimalCostsFromStart = mapOf<String, Int>(
        "A" to 6,
        "B" to 2,
        "final" to Int.MAX_VALUE
    )

    val parents = mapOf<String, String>(
        "A" to "start",
        "B" to "start",
        "final" to ""
    )
}

private data class GraphPoints(
    val start: String,
    val end: String
)
