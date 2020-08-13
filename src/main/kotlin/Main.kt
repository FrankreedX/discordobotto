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

                //to piss frank off
                if (message.author!!.username == "Frankreed") {
                    if (content.contains("anime")) {
                        botPrint("fucking weeb")
                    }
                    if (content.contains("ye")) {
                        botPrint("no")
                    }
                    if (content.contains("stop")) {
                        botPrint("bitch")
                    }
                    if (content.contains("weeb")) {
                        botPrint("What the fuck did you just fucking say about me, you little bitch? I'll have you know I graduated top of my class in the Navy Seals, and I've been involved in numerous secret raids on Al-Quaeda, and I have over 300 confirmed kills. I am trained in gorilla warfare and I'm the top sniper in the entire US armed forces. You are nothing to me but just another target. I will wipe you the fuck out with precision the likes of which has never been seen before on this Earth, mark my fucking words. You think you can get away with saying that shit to me over the Internet? Think again, fucker. As we speak I am contacting my secret network of spies across the USA and your IP is being traced right now so you better prepare for the storm, maggot. The storm that wipes out the pathetic little thing you call your life. You're fucking dead, kid. I can be anywhere, anytime, and I can kill you in over seven hundred ways, and that's just with my bare hands. Not only am I extensively trained in unarmed combat, but I have access to the entire arsenal of the United States Marine Corps and I will use it to its full extent to wipe your miserable ass off the face of the continent, you little shit. If only you could have known what unholy retribution your little \"clever\" comment was about to bring down upon you, maybe you would have held your fucking tongue. But you couldn't, you didn't, and now you're paying the price, you goddamn idiot. I will shit fury all over you and you will drown in it. You're fucking dead, kiddo.")
                    }
                    if (content.contains("what did you do")) {
                        botPrint("ur mom lol")
                    }
                }
            }
        }
    }
    bot.login()
}