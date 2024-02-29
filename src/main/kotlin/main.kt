val minute: Double = 60.0
val hour: Double = 3600.0
val day: Double = 86400.0
fun main (){
    var result = agoToTex (3*day)
    println(result)
}

fun agoToTex (second:Double): String {
    var message = when (second) {
        in 0.0..minute.toDouble() -> "был(а) только что"
        in (1.0 + minute)..hour.toDouble() -> wordsForMinute(second)
        in (1.0 + hour)..day.toDouble() -> wordsForHour(second)
        in (1.0 * day)..(2.0 * day) -> "был(а) вчера"
        in (3.0 * day)..(4.0 * day) -> "был(а) позавчера"
        else -> "был(а) давно"
    }
    return message
}
     fun wordsForMinute (second: Double): String {
         var toMinute = (( second / 3600) * 60).toInt()
         var wordsForMinute = when (second) {
             60.0, 1260.0, 1860.0, 2460.0, 3060.0 -> "был " + toMinute + " минуту назад"
             120.0, 180.0, 240.0, 1320.0, 1380.0, 1440.0, 1920.0, 1980.0, 2040.0, 2520.0, 2580.0, 2640.0, 3120.0, 3180.0, 3240.0 -> "был " + toMinute + " минуты назад"
             else -> "был " + toMinute + " минут назад"
         }
         return wordsForMinute
     }
            fun wordsForHour (second: Double):String {
                var toHour = ((second / 86400) * 24).toInt()
                var wordsForHour = when (second) {
                    3600.0, 75600.0 -> "был " + toHour + " час назад"
                    in 18000.0..72000.0 -> "был " + toHour + " часов назад"
                    else -> "был " + toHour + " часа назад"
                }
                return wordsForHour
            }