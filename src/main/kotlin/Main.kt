import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.event.message.*
import com.gitlab.kordlib.core.on
import moe.ganen.jikankt.JikanKt

suspend fun main(){
    val bot = Kord("NzI1ODUwNTcyOTM4MjgwOTgx.XvVeDQ._tkA1qN7-hNaZ1sIpNaLGpByKpU")
    val database = Database()
    bot.on<MessageCreateEvent> {
        val content = message.content.toLowerCase()
        val botPrint: suspend (String) -> Unit = {text: String -> message.channel.createMessage(text)}

        if(message.channel.id.value=="725851384846745652"){
            if(message.author!!.isBot==null) {
                //Commands
                when (content) {
                    "!shove", "!push" -> botPrint(database.getRandomHentai())
                    "!roastme" -> botPrint("say pls bitch")
                    "!plsroastme" -> botPrint(database.getRandomRoasts())
                }

                //MAL queries
                //anime
                if (content.contains('}') && content.contains('{')) {
                    val tempString = content.substring(0, content.indexOf('}'))
                    if (tempString.contains('{')) {
                        val searchQuery = tempString.substring(tempString.lastIndexOf('{') + 1)
                        botPrint(JikanKt.searchAnime(searchQuery).results!![0]!!.url!!)
                    }
                }
                //manga
                if (content.contains('>') && content.contains('<')) {
                    val tempString = content.substring(0, content.indexOf('>'))
                    if (tempString.contains('<')) {
                        val searchQuery = tempString.substring(tempString.lastIndexOf('<') + 1)
                        botPrint(JikanKt.searchManga(searchQuery).results!![0]!!.url!!)
                    }
                }

                //to piss nishant off
                if (message.author!!.username == "meche") {
                    if (content.contains("weeb")) {
                        botPrint("no u")
                    }
                    if (content == "shutup") {
                        botPrint("you weak sauce tsundere admit it")
                    }
                }
            }
        }
    }
    bot.login()
}