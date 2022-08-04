package MVVM.Fruit.App.repository

import MVVM.Fruit.App.models.RetrofitInstance

class FruitysRepository {

    suspend fun getFruitInfo()=
        RetrofitInstance.api.getFruitInfo()
}