data class ParseItem(
    val batters: BattersX,
    val id: String,
    val name: String,
    val ppu: Double,
    val topping: List<ToppingX>,
    val type: String
)