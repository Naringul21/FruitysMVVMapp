package MVVM.Fruit.App.models

import java.io.Serializable

data class FruitResponse(
     val genus: String,
     val name: String,
     val id: Int,
     val family: String,
     val order: String,
     val nutritions: Nutritions
) : Serializable
