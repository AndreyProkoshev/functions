var masterCardCom: Double = 0.006
var overMastercardCom: Int = 20
var visaCom: Double = 0.0075

fun main() {
    println(commision("Visa", 200000, 100_000))
}

fun commision(typeCard: String, transferMounth: Int, transfer: Int): Any {
    return when (typeCard) {
        "MasterCard",
        -> if (transferMounth + transfer <= 600_000 && transfer <= 150_000) {
            if (transferMounth <= 75000) {
                0
            } else {
                transfer * masterCardCom + overMastercardCom
            }
        } else "1"

        "Мир" ->
            if (transferMounth + transfer <= 600_000 && transfer <= 150_000) {
                0
            } else "Превышен лимит"

        "Visa",
        -> if (transferMounth + transfer <= 600_000 && transfer <= 150_000) {
            if ((transfer * visaCom) < 35) {
                35
            } else {
                transfer * visaCom
            }
        } else "Превышен лимит"

        else -> "Тип карты не подерживается"
    }
}




