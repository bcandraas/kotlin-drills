package drill7_async_dispatcher

import kotlinx.coroutines.*

suspend fun calculateTotal(): Int {
    delay(1000)
    return 150000
}

suspend fun checkStock(): Boolean {
    delay(1000)
    return true
}

fun main() = runBlocking {
    println("Memproses checkout pesanan...")

    val priceDeferred = async(Dispatchers.IO) { calculateTotal() }
    val stockDeferred = async(Dispatchers.IO) { checkStock() }

    val totalPrice = priceDeferred.await()
    val isAvailable = stockDeferred.await()

    if (isAvailable) {
        println("Checkout Berhasil! Total Pembayaran: Rp$totalPrice")
    } else {
        println("Checkout Gagal! Stok barang habis.")
    }
}