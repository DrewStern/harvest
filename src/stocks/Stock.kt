package stocks

data class Stock(
    val gameType: GameType,
    // can be negative?? in order to demonstrate state transitions and help reporting
    val quantity: Int
)