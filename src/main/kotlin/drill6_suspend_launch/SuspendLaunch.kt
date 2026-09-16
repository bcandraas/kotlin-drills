import kotlinx.coroutines.*

suspend fun fetchData(): String {
    delay(1000) // Pausing tanpa nge-freeze UI/thread
    return "Data berhasil dimuat!"
}

fun main() = runBlocking {
    println("Program dimulai...")

    launch {
        val result = fetchData()
        println("Hasil: $result")
    }

    println("Program tetap berjalan (non-blocking)...")
}