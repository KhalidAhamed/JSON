import com.google.gson.annotations.SerializedName

data class ParseModelItem(
//    @SerializedName("batters")
    val batters: Batters,
//    @SerializedName("id")
    val id: String,
//    @SerializedName("name")
    val name: String,
//    @SerializedName("ppu")
    val ppu: Double,
//    @SerializedName("topping")
    val topping: List<Topping>,
//    @SerializedName("type")
    val type: String
)