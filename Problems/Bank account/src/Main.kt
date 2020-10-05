data class BankAccount(var deposited: Long, var withdrawn: Long) {
    var balance: Long = deposited - withdrawn
} // write the BankAccount class here