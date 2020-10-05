import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    val country1 = input.next()
    val country2 = input.next()
    println(Country.isCountryCurrencyEquals(country1, country2))
}

enum class Currency(val currencyName: String) {
    EURO("Euro"),
    CFA_FRANC("CFA franc"),
    EASTER_CARIBBEAN_DOLLAR("Easter Caribbean dollar"),
    CANADIAN_DOLLAR("Canadian dollar"),
    AUSTRALIAN_DOLLAR("Australian dollar"),
    BRAZILIAN_REAL("Brazilian real"),
    NULL("")
}

enum class Country(val countryName: String, val currency: Currency) {
    GERMANY("Germany", Currency.EURO),
    MALI("Mali", Currency.CFA_FRANC),
    DOMINICA("Dominica", Currency.EASTER_CARIBBEAN_DOLLAR),
    CANADA("Canada", Currency.CANADIAN_DOLLAR),
    SPAIN("Spain", Currency.EURO),
    AUSTRALIA("Australia", Currency.AUSTRALIAN_DOLLAR),
    BRAZIL("Brazil", Currency.BRAZILIAN_REAL),
    SENEGAL("Senegal", Currency.CFA_FRANC),
    FRANCE("France", Currency.EURO),
    GRENADA("Grenada", Currency.EASTER_CARIBBEAN_DOLLAR),
    KIRIBATI("Kiribati", Currency.AUSTRALIAN_DOLLAR),
    NULL("", Currency.NULL);

    companion object {
        fun isThereCountry(name: String): Boolean {
            for (country in values()) {
                if (country.countryName == name) return true
            }
            return false
        }
        fun isCountryCurrencyEquals(country1: String, country2: String): Boolean {
            return isThereCountry(country1) && isThereCountry(country2) &&
                    valueOf(country1.toUpperCase()).currency ==
                    valueOf(country2.toUpperCase()).currency
        }
    }
}