package drill3_scope_func

data class User(var nama: String = "", var umur: Int = 0, var kota: String = "")

fun main() {
    val user = User().apply {
        nama = "Bintang"
        umur = 25
        kota = "Madiun"
    }
    println("Setelah apply: $user")

    val userSama = user.also {
        println("Mengecek user: ${it.nama} dari ${it.kota}")
    }
    println("Setelah also: $userSama")

    val ringkasan = user.run {
        val status = if (umur >= 18) "dewasa" else "anak-anak"
        "$nama ($status) tinggal di $kota"
    }
    println("Setelah run: $ringkasan")

    val namaBesar = user.nama.let {
        it.uppercase()
    }
    println("Setelah let: $namaBesar")
}