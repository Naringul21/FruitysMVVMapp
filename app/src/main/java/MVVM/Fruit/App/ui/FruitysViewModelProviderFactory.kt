package MVVM.Fruit.App.ui

import MVVM.Fruit.App.repository.FruitysRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FruitysViewModelProviderFactory(val fruitysRepository :FruitysRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FruitysViewModel(fruitysRepository) as T
    }
}