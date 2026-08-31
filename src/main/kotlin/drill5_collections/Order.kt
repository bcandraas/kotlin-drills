package drill5_collections

data class Order(val id: Int, val amount: Double, val category: String)

fun main() {
    val orders = listOf(
        Order(1, 15.0, "Electronics"),
        Order(2, 40.0, "Books"),
        Order(3, 80.0, "Electronics"),
        Order(4, 25.0, "Books"),
        Order(5, 120.0, "Clothing")
    )

    // 1. filter: Keep only high-value orders (removes small orders)
    val highValueOrders = orders.filter { it.amount > 30.0 }
    println("Filtered (> 30): $highValueOrders")

    // 2. map: Transform list of Order objects into just a list of IDs
    val orderIds = orders.map { it.id }
    println("Mapped (IDs only): $orderIds")

    // 3. groupBy: Bucket orders by their category
    val ordersByCategory = orders.groupBy { it.category }
    println("Grouped by Category: $ordersByCategory")

    // RECREATE logic on amounts: Filter even-dollar amounts and double them
    val rawPrices = listOf(10, 15, 20, 25, 30)
    val doubledEvens = rawPrices
        .filter { it % 2 == 0 }
        .map { it * 2 }

    println("Doubled Evens: $doubledEvens") // [20, 40, 60]
}