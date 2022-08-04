package MVVM.Fruit.App.ui

import MVVM.Fruit.App.models.FruitResponse
import MVVM.Fruit.App.repository.FruitysRepository
import MVVM.Fruit.App.util.Resource
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class FruitysViewModel(val fruitysRepository: FruitysRepository) :ViewModel() {

    val fruitInfo:MutableLiveData<Resource<List<FruitResponse>>> = MutableLiveData()
    init {
        getFruitInfo()
    }

    fun getFruitInfo()=viewModelScope.launch{
         fruitInfo.postValue(Resource.Loading())
        val response=fruitysRepository.getFruitInfo()
        fruitInfo.postValue(handleFruitysInfoResponse(response))
    }

    private fun handleFruitysInfoResponse(response: Response<List<FruitResponse>>): Resource<List<FruitResponse>>{
        if (response.isSuccessful){
            response.body()?.let { resultresponse->
                return Resource.Success(resultresponse)

            }
        }
        return Resource.Error(response.message())
    }

}