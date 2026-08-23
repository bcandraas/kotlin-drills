package drill1_null_safety

fun main(){
    val a: String? = "Kotlin"
    val b: String? = null

    // ?. — safe call: checks for null, returns length or null
    println(a?.length)   // will return 6
    println(b?.length)   // will return null

    // ?: — Elvis operator: if the value is null, use a fallback instead
    println(a?.length ?: -1)   // 6, fallback not used
    println(b?.length ?: -1)   // -1, use fallback

    // !! — not-null assertion: check for null, if there's null then program will crash
    println(a!!.length)   // 6, works fine, because not null
    println(b!!.length)   // crash, NullPointerException

    //other case 1:
    val cost: Double? = 15000.0
    val freeCost: Double? = null
    val fee = (cost ?: 0.0) >= 10000.0
    val fee2 = (freeCost ?: 0.0) >= 10000.0
    println(fee)   // true
    println(fee2)  // false


    //other case 2:
    data class Address(val city: String, val zipcode: String?)
    data class User (val name:String, val address: Address?)

    val user1:User? = User("Bintang", Address("Ngawi", "63218"))
    val user2:User? = User("Sari", null)
    val user3:User? = null

    val res1 = user1?.address?.zipcode ?: "Zipcode not found"
    val res2 = user2?.address?.zipcode ?: "Zipcode not found"
    val res3 = user3?.address?.zipcode ?: "Zipcode not found"

    println("$res1, $res2, $res3") //63218, Zipcode not found, Zipcode not found
}