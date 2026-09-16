package drill7_async_dispatcher

import kotlinx.coroutines.*

suspend fun fetchUserProfile(): String {
    delay(1000)
    return "User: Alex"
}

suspend fun fetchUserOrders(): String {
    delay(1000)
    return "Orders: [Baju, Sepatu]"
}

fun main() = runBlocking {
    println("Memulai loading dashboard...")

    val profileDeferred = async(Dispatchers.IO) { fetchUserProfile() }
    val ordersDeferred  = async(Dispatchers.IO) { fetchUserOrders() }

    val profile = profileDeferred.await()
    val orders  = ordersDeferred.await()

    println("Dashboard Siap -> $profile | $orders")
}