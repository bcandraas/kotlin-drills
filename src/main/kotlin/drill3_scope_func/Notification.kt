package drill3_scope_func

data class Notification(var recipient: String = "", var title: String = "", var body: String = "")

fun sendNotification(notification: Notification): Boolean {
    println("Sending to ${notification.recipient}: [${notification.title}] ${notification.body}")
    return true
}

fun main() {
    // apply initializes/configures the payload, then passes it directly into let to execute the send operation
    val isSent = Notification().apply {
        recipient = "dev-team@company.com"
        title = "Build Succeeded"
        body = "Release candidate v2.4.0 is ready for deployment."
    }.let { payload ->
        sendNotification(payload)
    }

    println("Notification delivered successfully: $isSent")
}