import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.message.MessageCreateEvent
import com.gitlab.kordlib.core.on
import moe.ganen.jikankt.JikanKt

suspend fun main(){
    val bot = Kord("NzI1ODUwNTcyOTM4MjgwOTgx.XvVeDQ._tkA1qN7-hNaZ1sIpNaLGpByKpU")
    val database = Database()
    bot.on<MessageCreateEvent> {
        if(message.channel.id.value=="725851384846745652"){
            if(message.author!!.isBot==null) {
                //Commands
                if (message.content == "!shove" || message.content == "!push") {
                    message.channel.createMessage(database.getRandomHentai())
                }
                if (message.content == "!roastme") {
                    message.channel.createMessage("say pls bitch")
                }
                if (message.content == "!plsroastme") {
                    message.channel.createMessage(database.getRandomRoasts())
                }

                //MAL queries
                //anime
                if (message.content.contains('}') && message.content.contains('{')) {
                    val tempString = message.content.substring(0, message.content.indexOf('}'))
                    if (tempString.contains('{')) {
                        val searchQuery = tempString.substring(tempString.lastIndexOf('{') + 1)
                        message.channel.createMessage(JikanKt.searchAnime(searchQuery).results!![0]!!.url!!)
                    }
                }
                //manga
                if (message.content.contains('>') && message.content.contains('<')) {
                    val tempString = message.content.substring(0, message.content.indexOf('>'))
                    if (tempString.contains('<')) {
                        val searchQuery = tempString.substring(tempString.lastIndexOf('<') + 1)
                        message.channel.createMessage(JikanKt.searchManga(searchQuery).results!![0]!!.url!!)
                    }
                }

                //to piss nishant off
                if (message.author!!.username == "meche") {
                    val content = message.content.toLowerCase()
                    if (content.contains("weeb")) {
                        message.channel.createMessage("no u")
                    }
                    if (content == "shutup") {
                        message.channel.createMessage("you weak sauce tsundere admit it")
                    }
                    if(content.contains("fuck")){
                        message.channel.createMessage("ur mom")
                    }
                }
            }
        }
    }
    bot.login()
}