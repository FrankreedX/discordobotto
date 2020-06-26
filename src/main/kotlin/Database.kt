import kotlin.random.Random

class Database {
    private val roasts = listOf(
        "I know 5 fat people in this server and you're 3 of them",
        "You egg?",
        "ur mom",
        "you walking in front of an air purifier makes it work full power"
    )
    private val hentai = listOf(
        "やめて!",
        "だめ！",
        "おちんちんがつごいです"
    )
    fun getRandomRoasts():String{
        return roasts[Random.nextInt(0,roasts.size)]
    }
    fun getRandomHentai():String{
        return hentai[Random.nextInt(0,hentai.size)]
    }
}