package MVVM.Fruit.App.api

import MVVM.Fruit.App.models.FruitResponse
import retrofit2.Response
import retrofit2.http.GET

interface FruitApi {

    @GET()
    suspend fun getFruitInfo() :Response<List<FruitResponse>>
}