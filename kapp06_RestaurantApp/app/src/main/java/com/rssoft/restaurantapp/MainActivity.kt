package com.rssoft.restaurantapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.rssoft.restaurantapp.models.FoodItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_item_layout.view.*

class MainActivity : AppCompatActivity() {

    private val foodItems = arrayListOf<FoodItem>()
    private var gridAdapter: MyGridAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFoodItems()
        gridAdapter = MyGridAdapter(foodItems)
        gvFoodIems.adapter = gridAdapter
    }

    fun loadFoodItems() {
        foodItems.add(FoodItem("Coffee", R.drawable.coffee_pot, "Coffee description"))
        foodItems.add(FoodItem("Espresso", R.drawable.espresso, "Espresso"))
        foodItems.add(
            FoodItem(
                "French Fries",
                R.drawable.french_fries,
                "cuboid shaped fried potatoes"
            )
        )
        foodItems.add(FoodItem("Honey", R.drawable.honey, "the paste of love"))
        foodItems.add(
            FoodItem(
                "Strawberry Ice Cream",
                R.drawable.strawberry_ice_cream,
                "strawberries are delicious"
            )
        )
        foodItems.add(FoodItem("Sugar Cubes", R.drawable.sugar_cubes, "So Sweet"))
    }

    inner class MyGridAdapter(val items: ArrayList<FoodItem>) : BaseAdapter() {
        override fun getCount(): Int {
            return items.size
        }

        override fun getItem(idx: Int): Any {
            return items[idx]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(idx: Int, p1: View?, vg: ViewGroup?): View {
            val inflator = LayoutInflater.from(vg!!.context)
            val view = inflator.inflate(R.layout.food_item_layout, null)
            view.ivFoodItem.setImageResource(items[idx].img)
            view.tvFoodItem.text = items[idx].name
            view.setOnClickListener {
                val intent = Intent(view.context, ItemDetailsActivity::class.java)
                intent.putExtra("item", items[idx])
                view.context.startActivity(intent)
            }
            return view
        }

    }
}