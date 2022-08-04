package MVVM.Fruit.App.models

import java.io.Serializable

data class Nutritions(
    val carbohydrates: Double,
    val protein: Double,
    val fat: Double,
    val calories: Int,
    val sugar: Double
) : Serializable
