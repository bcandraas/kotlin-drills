package drill3_scope_func

data class Article(
    var title: String = "",
    var author: String? = null,
    var urlImage: String? = null,
    var isBookmarked: Boolean = false
)

fun fetchArticle(failed: Boolean) : Article? {
    val status = if (failed){
        null
    } else {
        val news = Article().apply {
            title = "Breaking News"
            author = null
            urlImage = "https://inca.ac.id/wp-content/uploads/2025/04/Breaking-News.webp"
        }
        news
    }
    return status


}

fun showArticle(artikel: Article?): String {
    return artikel?.let { art ->
        val penulis = art.author ?: "Penulis tidak diketahui"
        "${art.title} oleh $penulis"
    } ?: "Artikel tidak ditemukan"
}
fun bookmarkArticle(article: Article) :Article {
    val setBookmark = article.also {
        it.isBookmarked = true
        println("Artikel dibookmark: ${it.title}")
    }
    return setBookmark
}

fun summaryArticle(article: Article){
    println("Title: ${article.title}, Author: ${article.author}, Bookmark Status: ${article.isBookmarked}")
}
fun main(){
    // Success fetch
    val artikelSukses = fetchArticle(false)
    if (artikelSukses != null) {
        val bookmarked = bookmarkArticle(artikelSukses)
        println(showArticle(bookmarked))
        summaryArticle(bookmarked)
    }

    println()

    // Failed fetch
    val artikelGagal = fetchArticle(true)
    println(showArticle(artikelGagal))




}

