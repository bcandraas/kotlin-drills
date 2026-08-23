sealed class Upload{
    object Idle : Upload()
    data class Uploading(val percent:Int) : Upload()
    data class Gagal (val message: String) : Upload()
}

fun getStatus(): Upload{
    return when ((0..2).random()){
        0 -> Upload.Idle
        1 -> Upload.Uploading((0..100).random())
        else -> Upload.Gagal("Gagal upload!")
    }
}

fun main() {
    val status = getStatus()
    when (status){
        is Upload.Idle -> {
            println("Silakan upload file")
        }
        is Upload.Uploading -> {
            println("Sedang proses: ${status.percent}%")
        }
        is Upload.Gagal -> {
            println(status.message)
        }
    }
}