import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import com.gitlab.kordlib.core.on
import kotlin.random.Random

suspend fun main(){
    val bot = Kord("NzI1ODUwNTcyOTM4MjgwOTgx.XvVeDQ._tkA1qN7-hNaZ1sIpNaLGpByKpU")
    val hentiWordPool = listOf("やめて!", "だめ！","おちんちんがつごいです")
    bot.on<MessageCreateEvent> {
        if(message.author!!.isBot==null) {
            if (message.content == "!shove" || message.content == "!push") {
                message.channel.createMessage(hentiWordPool[Random.nextInt(0, 3)])
            }
        }
    }
    bot.login()
}