package drill4_higher_order_func

// 3-line higher-order function: accepts a double and a calculation lambda, then calls it
fun calculateFinalPrice(basePrice: Double, discountStrategy: (Double) -> Double): Double {
    return discountStrategy(basePrice)
}

fun main() {
    val originalPrice = 100.0

    // Lambda 1: 20% off sale
    val salePrice = calculateFinalPrice(originalPrice) { price -> price * 0.80 }

    // Lambda 2: Flat $15 coupon
    val couponPrice = calculateFinalPrice(originalPrice) { price -> price - 15.0 }

    println("Sale Price: $$salePrice")     // Output: Sale Price: $80.0
    println("Coupon Price: $$couponPrice") // Output: Coupon Price: $85.0
}