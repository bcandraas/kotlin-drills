sealed class ErrorType{
    data class InsufficientFunds(val shortfall: Double) : ErrorType()
    object NetworkError : ErrorType()
    data class InvalidCard(val reason: String) : ErrorType()
}

sealed class PaymentStatus{
    object Idle : PaymentStatus()
    data class Processing(val amount: Double) : PaymentStatus()
    data class Success(val transId: String)  : PaymentStatus()
    data class Failed(val error: ErrorType) : PaymentStatus()
}

fun getPaymentStatus(): PaymentStatus{
    return when ((0..3).random()){
        0 -> PaymentStatus.Idle
        1 -> PaymentStatus.Processing((100..1000).random().toDouble())
        2 -> PaymentStatus.Success("TRX${(1000..9999).random()}")
        else -> {
            val error = when ((0..2).random()) {
                0 -> ErrorType.InsufficientFunds((0..100).random().toDouble())
                1 -> ErrorType.NetworkError
                else -> ErrorType.InvalidCard("Kartu kadaluarsa")
            }
            PaymentStatus.Failed(error)
        }
    }
}

fun main(){
    val paystat = getPaymentStatus()
    when (paystat){
        is PaymentStatus.Idle -> {
            println("Menunggu pembayaran..")
        }
        is PaymentStatus.Processing -> {
            println("Memproses ${paystat.amount}")
        }
        is PaymentStatus.Success -> {
            println("Pembayaran berhasil dengan nomor transaksi ${paystat.transId}")
        }
        is PaymentStatus.Failed -> {
            when (paystat.error) {
                is ErrorType.InsufficientFunds -> println("Saldo kurang Rp${paystat.error.shortfall}")
                is ErrorType.NetworkError -> println("Jaringan bermasalah")
                is ErrorType.InvalidCard -> println("Kartu ditolak: ${paystat.error.reason}")
            }
        }
    }
}