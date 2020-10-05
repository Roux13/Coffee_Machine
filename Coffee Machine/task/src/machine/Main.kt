package machine

import java.util.*

class CoffeeMachine(private var water: Int, private var milk: Int, private var coffeeBeans: Int,
                    private var cups: Int, private var money: Int) {
    var state = MachineState.CHOOSING_ACTION

    init {
        Output.printMainMenu()
    }

    fun processInput(input: String) {
        when (state) {
            MachineState.CHOOSING_ACTION -> selectMainMenuItem(input)
            MachineState.MAKING_COFFEE -> {
                if (input != "back") {
                    makeCoffee(Integer.parseInt(input))
                }
                state = MachineState.CHOOSING_ACTION
                Output.printMainMenu()
            }
            MachineState.REFILLING_WATER -> {
                refillWater(Integer.parseInt(input))
                state = MachineState.REFILLING_MILK
                Output.askAmountMilk()
            }
            MachineState.REFILLING_MILK -> {
                refillMilk(Integer.parseInt(input))
                state = MachineState.REFILLING_BEANS
                Output.askAmountBeans()
            }
            MachineState.REFILLING_BEANS -> {
                refillBeans(Integer.parseInt(input))
                state = MachineState.REFILLING_CUPS
                Output.askAmountCups()
            }
            MachineState.REFILLING_CUPS -> {
                refillCups(Integer.parseInt(input))
                state = MachineState.CHOOSING_ACTION
                Output.printMainMenu()
            }
        }
    }

    private fun selectMainMenuItem(item: String) {
        when (item) {
            MenuItem.BUY.itemName -> {
                state = MachineState.MAKING_COFFEE
                Output.askCoffeeType()
                return
            }
            MenuItem.FILL.itemName -> {
                state = MachineState.REFILLING_WATER
                Output.askAmountWater()
                return
            }
            MenuItem.TAKE.itemName -> takeMoney()
            MenuItem.REMAINING.itemName -> Output.printRemaining(this)
            MenuItem.EXIT.itemName -> {
                state = MachineState.SHUTDOWN
                return
            }
        }
        Output.printMainMenu()
    }



    private fun makeCoffee(type: Int) {
        when (type) {
            CoffeeType.ESPRESSO.number -> makeEspresso()
            CoffeeType.LATTE.number -> makeLatte()
            CoffeeType.CAPPUCCINO.number -> makeCappuccino()
            0 -> return
        }
    }

    private fun refillWater(amount: Int) {
        this.water += amount
    }

    private fun refillMilk(amount: Int) {
        milk += amount
    }

    private fun refillBeans(amount: Int) {
        coffeeBeans += amount
    }

    private fun refillCups(amount: Int) {
        cups += amount
    }

    private fun takeMoney() {
        Output.printTakenMoney(this)
        money = 0
    }

    private fun makeEspresso() {
        val needWater = 250
        val needMilk = 0
        val needBeans = 16
        val cost = 4
        if (isEnoughSupplies(250, 0, 16)) {
            cups--
            water -= needWater
            coffeeBeans -= needBeans
            money += cost
        }
    }

    private fun makeLatte() {
        val needWater = 350
        val needMilk = 75
        val needBeans = 20
        val cost = 7
        if (isEnoughSupplies(needWater, needMilk, needBeans)) {
            cups--
            water -= needWater
            milk -= needMilk
            coffeeBeans -= needBeans
            money += cost
        }
    }

    private fun makeCappuccino() {
        val needWater = 200
        val needMilk = 100
        val needBeans = 12
        val cost = 6
        if (isEnoughSupplies(needWater, needMilk, needBeans)) {
            cups--
            water -= needWater
            milk -= needMilk
            coffeeBeans -= needBeans
            money += cost
        }
    }

    private fun isEnoughSupplies(needWater: Int, needMilk: Int, needBeans: Int): Boolean {
        var isEnough = false
        when {
            cups < 1 -> Output.printNotEnoughCups()
            water < needWater -> Output.printNotEnoughWater()
            milk < needMilk -> Output.printNotEnoughMilk()
            coffeeBeans < needBeans -> Output.printNotEnoughBeans()
            else -> {
                Output.printMakingCoffee()
                isEnough = true
            }
        }
        return isEnough
    }

    object Output {

        fun printMainMenu() {
            println("Write action (${MenuItem.BUY.itemName}, ${MenuItem.FILL.itemName}," +
                    " ${MenuItem.TAKE.itemName}, ${MenuItem.REMAINING.itemName}," +
                    " ${MenuItem.EXIT.itemName}): ")
            MachineState.CHOOSING_ACTION
        }
        fun printRemaining(coffeeMachine: CoffeeMachine) {
            println("The coffee machine has: ")
            println("${coffeeMachine.water} of water")
            println("${coffeeMachine.milk} of milk")
            println("${coffeeMachine.coffeeBeans} of coffee beans")
            println("${coffeeMachine.cups} of disposable cups")
            println("$${coffeeMachine.money} of money")
            println()
        }

        fun askCoffeeType() {
            println("What do you want to buy? ${CoffeeType.ESPRESSO.number} - " +
                    "${CoffeeType.ESPRESSO.typeName}, ${CoffeeType.LATTE.number} - " +
                    "${CoffeeType.LATTE.typeName}, ${CoffeeType.CAPPUCCINO.number} - " +
                    "${CoffeeType.CAPPUCCINO.typeName}, back - to main menu: ")
        }

        fun askAmountWater() {
            println("Write how many ml of water do you want to add: ")
        }

        fun askAmountMilk() {
            println("Write how many ml of milk do you want to add: ")
        }

        fun askAmountBeans() {
            println("Write how many grams of coffee beans do you want to add: ")
        }

        fun askAmountCups() {
            println("Write how many disposable cups of coffee do you want to add: ")
        }

        fun printTakenMoney(coffeeMachine: CoffeeMachine) {
            println("I gave you $${coffeeMachine.money}")
            println()
        }

        fun printNotEnoughCups() {
            println("Sorry, not enough disposable cups!")
            println()
        }

        fun printNotEnoughWater() {
            println("Sorry, not enough water!")
            println()
        }

        fun printNotEnoughMilk() {
            println("Sorry, not enough milk!")
            println()
        }

        fun printNotEnoughBeans() {
            println("Sorry, not enough coffee beans!")
            println()
        }

        fun printMakingCoffee() {
            println("I have enough resources, making you a coffee!")
            println()
        }
    }

}

enum class MachineState {
    CHOOSING_ACTION,
    REFILLING_WATER,
    REFILLING_MILK,
    REFILLING_BEANS,
    REFILLING_CUPS,
    MAKING_COFFEE,
    SHUTDOWN;
}

enum class MenuItem(val itemName: String) {
    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");
}

enum class CoffeeType(val number: Int, val typeName: String) {
    ESPRESSO(1, "espresso"),
    LATTE(2, "latte"),
    CAPPUCCINO(3, "cappuccino")
}

fun main() {
    val coffeeMachine = CoffeeMachine(400, 540, 120, 9, 550)
    val scanner = Scanner(System.`in`)

    while (coffeeMachine.state != MachineState.SHUTDOWN) {
        coffeeMachine.processInput(scanner.nextLine())
    }
}



