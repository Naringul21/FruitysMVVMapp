package MVVM.Fruit.App.ui

import MVVM.Fruit.App.repository.FruitysRepository
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fruitysmvvmapp.R
import kotlinx.android.synthetic.main.activity_fruitys.*

class FruitysActivity : AppCompatActivity() {

    lateinit var viewModel: FruitysViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            R.layout.activity_fruitys)
        val fruitysRepository = FruitysRepository()
        val viewModelProviderFactory = FruitysViewModelProviderFactory(fruitysRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(FruitysViewModel::class.java)
        bottomNavigationView.setupWithNavController(fruitysNavHostFragment.findNavController())
    }
}