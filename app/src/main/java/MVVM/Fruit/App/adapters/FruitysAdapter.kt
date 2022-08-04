package MVVM.Fruit.App.adapters

import MVVM.Fruit.App.models.FruitResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fruitysmvvmapp.R
import kotlinx.android.synthetic.main.rv_items_fruitys.view.*

class FruitysAdapter :RecyclerView.Adapter<FruitysAdapter.FruitViewHolder>() {

    inner class FruitViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)

    private val differCallBack=object :DiffUtil.ItemCallback<FruitResponse>() {
        override fun areItemsTheSame(oldItem: FruitResponse, newItem: FruitResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FruitResponse, newItem: FruitResponse): Boolean {
            return oldItem == newItem
        }
    }
        val differ=AsyncListDiffer(this, differCallBack)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
       return FruitViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.rv_items_fruitys, parent, false)
       )
    }
    private var onItemClickListener:((FruitResponse)->Unit)?= null

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruitys=differ.currentList[position]
        holder.itemView.apply {
            FruitName.text=fruitys.name
            FruitOrder.text=fruitys.order
            FruitProtein.text=fruitys.nutritions.protein.toString()
            FruitFat.text=fruitys.nutritions.fat.toString()
            FruitCalories.text=fruitys.nutritions.calories.toString()
            FruitCarbohidrates.text=fruitys.nutritions.carbohydrates.toString()
            FruitSugar.text=fruitys.nutritions.sugar.toString()
            FruitGenus.text=fruitys.genus
            FruitFamily.text=fruitys.family
            setOnClickListener {

                onItemClickListener?.let { it(fruitys) }
            }

        }


    }

    override fun getItemCount(): Int {
      return differ.currentList.size
    }

    fun setOnItemClickListener(listener: (FruitResponse)->Unit){
        onItemClickListener=listener
    }


}