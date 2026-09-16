package drill6_suspend_launch

import kotlinx.coroutines.*

suspend fun downloadFile(fileName: String): Int {
    println("Mulai mendownload $fileName...")
    delay(1500)
    return 100
}

fun main() = runBlocking {
    println("[UI] Layar aplikasi siap digunakan.")

    launch {
        val progress = downloadFile("update_game.zip")
        println("[UI] Notifikasi: Download $progress% selesai!")
    }

    println("[UI] Pengguna masih bisa klik tombol lain sambil menunggu download...")
}