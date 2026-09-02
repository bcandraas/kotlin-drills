data class User(var nama: String = "", var umur: Int = 0, var kota: String = "")

fun main() {

    // 1. APPLY — build an object and configure several properties at once.
    //    Returns the object itself (still a User).
    val user = User().apply {
        nama = "Bintang"
        umur = 25
        kota = "Madiun"
    }
    println("Setelah apply: $user")


    // 2. ALSO — do something on the side (logging, checking) without
    //    changing what flows through. Returns the same object (still User).
    val userSama = user.also {
        println("Mengecek user: ${it.nama} dari ${it.kota}")
    }
    println("Setelah also: $userSama")


    // 3. RUN — read from the object and compute something new.
    //    Returns the result of the last line, NOT the User anymore.
    val ringkasan = user.run {
        val status = if (umur >= 18) "dewasa" else "anak-anak"
        "$nama ($status) tinggal di $kota"   // last line -> this is what's returned
    }
    println("Setelah run: $ringkasan")


    // 4. LET — transform one value into another. Classic use: paired with
    //    a safe call (?.) to transform something that might be null.
    val namaBesar = user.nama.let {
        it.uppercase()
    }
    println("Setelah let: $namaBesar")


    // 5. WITH — same idea as `run` (access via `this`, returns last line),
    //    but called differently: with(object) { ... } instead of object.with { }.
    //    Useful when you want to do several things with one object without
    //    repeating its name.
    val detail = with(user) {
        println("Memproses data $nama")
        "Nama: $nama, Umur: $umur, Kota: $kota"
    }
    println("Setelah with: $detail")
}