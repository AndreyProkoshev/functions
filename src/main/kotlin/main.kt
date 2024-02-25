val minute: Int = 60
val hour: Int = 60 * 60
val day: Int = 24 * 60 * 60
//var wordsForMinute: String = ""
//var wordsForHour: String = ""
fun main (){
    val result = agoToTex (60)
    println(result)
}

fun agoToTex (timeSecond:Int): String {
    var message: String = ""
    when (timeSecond) {
        in 0..minute -> "был(а) только что"
        in (1 + minute)..hour -> wordsForMinute()
        in (1 + hour)..day -> wordsForHour()
        in (2 * day)..(3 * day) -> "был(а) вчера"
        in (3 * day)..(4 * day) -> "был(а) позавчера"
        else -> "был(а) давно"
    }
    return message
}
     fun wordsForMinute (timeSecond: Int): String {
         val toMinute = (timeSecond / 3600) * 60
         val wordsForMinute = when (timeSecond) {
             60, 1260, 1860, 2460, 3060 -> "был " + toMinute + " минуту назад"
             120, 180, 240, 1320, 1380, 1440, 1920, 1980, 2040, 2520, 2580, 2640, 3120, 3180, 3240 -> "был" + toMinute + " минуты назад"
             else -> "был" + toMinute + " минут назад"
         }
         return wordsForMinute
     }
            fun wordsForHour (timeSecond: Int):String {
                val toHour = (timeSecond / 86400) * 60
                val wordsForHour = when (timeSecond) {
                    3600, 75600 -> "был" + toHour + " час назад"
                    in 18_000..72000 -> "был" + toHour + " часов назад"
                    else -> "был" + toHour + " часа назад"
                }
                return wordsForHour
            }