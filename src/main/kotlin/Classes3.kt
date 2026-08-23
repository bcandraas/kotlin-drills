sealed class OrderStatus {
    object Placed : OrderStatus()
    data class Shipped (val trackingNumber: String?, val estimatedDays: Int) : OrderStatus()
    data class Delivered (val signedBy: String?) : OrderStatus()
    data class Cancelled (val reason: String): OrderStatus()
}

fun getOrderStatus(): OrderStatus{
    return when ((0..3).random()){
        0 -> OrderStatus.Placed
        1 -> {
            val tracId = when ((0..1).random()){
                0 -> null
                else -> ("JX${(1000..9999).random()}")
            }
            OrderStatus.Shipped(tracId, ((2..10).random()))
        }
        2 -> {
            val signId = when ((0..1).random()){
                0 -> null
                else -> "JX${(1000..9999).random()}"
            }
            OrderStatus.Delivered(signId)
        }
        else -> OrderStatus.Cancelled("Status order sudah dibatalkan")
    }
}

fun main(){
    val status = getOrderStatus()
    when (status){
        is OrderStatus.Placed -> {
            println("Pesanan diterima")
        }
        is OrderStatus.Shipped -> {
            val resi = status.trackingNumber ?: "Nomor resi belum tersedia"
            println("$resi, akan sampai dalam ${status.estimatedDays} hari")
        }
        is OrderStatus.Delivered -> {
            val sign = status.signedBy ?: "Tidak ada tanda tangan tercatat"
            println ("Ditandatangani oleh ${sign}")
        }
        is OrderStatus.Cancelled -> {
            println(status.reason)
        }
    }
}