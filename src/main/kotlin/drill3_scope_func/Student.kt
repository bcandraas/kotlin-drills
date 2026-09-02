package drill3_scope_func

data class Siswa(var nama: String = "", var nilai: Int = 0, var kelas: String = "")

fun main(){

    var siswa = Siswa().apply{
        nama = "Ayu"
        nilai = 85
        kelas = "9"
    }
    println("Apply: $siswa")

    var siswaDaftar = siswa.also{
        println("Siswa Terdaftar : ${it.nama} dari kelas ${it.kelas}")
    }

    var keterangan = siswa.run{
        var status = if (nilai >= 75) "lulus" else "tidak Lulus"
        "Siswa $nama $status"
    }
    println(keterangan)

    var grading = siswa.nilai.let{
        if (it >= 90) {
            "A"
        } else if (it >= 75) {
            "B"
        } else "C"
    }
    println("Gradingnya adalah $grading")

    with(siswa){
        println("Nama siswa: $nama, Nilai: $nilai, Kelas: $kelas")
    }
}
