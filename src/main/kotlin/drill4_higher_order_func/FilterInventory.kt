package drill4_higher_order_func

// A higher-order function takes a lambda parameter and invokes it using `()`
fun filterInventory(items: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    return items.filter(predicate)
}

fun main() {
    val scores = listOf(45, 120, 85, 210, 30)

    // Passing a lambda directly into the higher-order function
    val highScores = filterInventory(scores) { score -> score > 100 }

    println("High scores: $highScores") // Output: High scores: [120, 210]
}