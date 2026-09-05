package drill4_higher_order_func

data class Siswa(val name: String, val score: Int)
fun cekGrading(items: List<Siswa>, predicate: (Siswa) -> Boolean): List<Siswa> {
    return items.filter(predicate)
}

fun main() {
    val daftarSiswa = listOf(
        Siswa("Ayu", 85),
        Siswa("Budi", 60),
        Siswa("Citra", 92),
        Siswa("Dedi", 70)
    )

    val siswaLulus = cekGrading(daftarSiswa) { it.score > 75 }.map { "${it.name} dengan nilai ${it.score}" }
    val jumlahLulus = siswaLulus.size
    println("Siswa yang lulus: $siswaLulus")
    println("Jumlah yang lulus: $jumlahLulus")

}