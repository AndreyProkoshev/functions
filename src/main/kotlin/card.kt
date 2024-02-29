var masterCardCom: Double = 0.006
var overMastercardCom: Int = 20
var visaCom: Double = 0.0075

fun main() {
    println(commision("Мир", 100000, 20_000))
}

fun commision(typeCard: String, transferMounth: Int, transfer: Int): Any {
    return when (typeCard) {
        "MasterCard",
        -> if (transferMounth + transfer <= 600_000 && transfer <= 150_000) {
            if (transferMounth + transfer <= 75000) {
                0
            }
            else if(transferMounth + transfer > 75000 && transferMounth <= 75000){
                (transferMounth + transfer - 75000) * masterCardCom + overMastercardCom
            }
            else {
                transfer * masterCardCom + overMastercardCom
            }
        } else "Превышен лимит"

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




