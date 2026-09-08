package drill5_collections

data class Artikel(
    val judul: String,
    val kategori: String,
    val jumlahDibaca: Int,
    val rating: Double?   // some articles haven't been rated yet
)

fun hitungNonRating(artikel: List<Artikel>):Int{
    val jumlah = artikel.filter { it.rating == null }.size
    return jumlah
}

fun main(){
    val artikelList = listOf(
        Artikel("Update Ekonomi", "Ekonomi", 1500, 4.2),
        Artikel("Berita Olahraga Terkini", "Olahraga", 800, null),
        Artikel("Politik Hari Ini", "Politik", 3200, 3.8),
        Artikel("Skor Pertandingan", "Olahraga", 5000, 4.9),
        Artikel("Kebijakan Baru", "Politik", 200, null),
        Artikel("Resesi Global", "Ekonomi", 2100, 4.5)
    )

    val popular = artikelList.filter { it.jumlahDibaca >= 1000 }.map { it.judul }
    println(popular)

    val sortKategori = artikelList.groupBy { it.kategori }
    for ((kategori, daftarArtikel) in sortKategori){
        val jumlahBelumDinilai = hitungNonRating(daftarArtikel)
        println("$kategori: $jumlahBelumDinilai artikel belum punya rating")
    }

    val artikelRating = artikelList.filter { it.rating != null }.map { "${it.judul} dengan rating ${it.rating}" }
    println(artikelRating)

    var artikelAvg = artikelList.filter { it.rating != null }.map { it.rating!! }.average()
    println("Rata-rata rating = $artikelAvg")
}