import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import com.gitlab.kordlib.core.on

suspend fun main(){
    val bot = Kord("NzI1ODUwNTcyOTM4MjgwOTgx.XvVeDQ._tkA1qN7-hNaZ1sIpNaLGpByKpU")
    val database = Database()
    bot.on<MessageCreateEvent> {
        println(database.getRandomHentai())
        if(message.author!!.isBot==null){
            if (message.content == "!shove" || message.content == "!push") {
                println(" asdfwae")
                println(database.getRandomHentai())
                message.channel.createMessage(database.getRandomHentai())
            }
            if (message.content == "!roastme"){
                message.channel.createMessage("say pls bitch")
            }
            if (message.content == "!plsroastme"){
                message.channel.createMessage(database.getRandomRoasts())
                println(" itasf")
                println(database.getRandomRoasts())
            }
        }
    }
    bot.login()
}