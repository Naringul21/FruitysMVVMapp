package MVVM.Fruit.App.ui

import MVVM.Fruit.App.adapters.FruitysAdapter
import MVVM.Fruit.App.models.FruitResponse
import MVVM.Fruit.App.util.Resource
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fruitysmvvmapp.R
import kotlinx.android.synthetic.main.fragment_fruitys.*


class FruitysFragment : Fragment(R.layout.fragment_fruitys) {
    lateinit var viewModel: FruitysViewModel
    lateinit var adapter: FruitysAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as FruitysActivity).viewModel
        setupRecyclerView()

        val TAG = "FruitysFragment"

        adapter.setOnItemClickListener {
            val bundle=Bundle().apply {
                putSerializable("fruitys", it)
            }
        }

        viewModel.fruitInfo.observe(viewLifecycleOwner, Observer { response->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { fruitResponse ->
                        adapter.differ.submitList(fruitResponse)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun hideProgressBar() {
        progress_bar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        progress_bar.visibility = View.VISIBLE
    }

    private fun setupRecyclerView() {
        adapter = FruitysAdapter()
        recycler_view.apply {
           adapter=adapter
            layoutManager = LinearLayoutManager(activity)
        }

        }
    }

