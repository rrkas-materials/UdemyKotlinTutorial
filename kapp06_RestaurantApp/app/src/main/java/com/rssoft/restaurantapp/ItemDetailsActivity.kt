package com.rssoft.restaurantapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rssoft.restaurantapp.models.FoodItem
import kotlinx.android.synthetic.main.activity_item_details.*

class ItemDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_details)
        val item = intent.getSerializableExtra("item") as FoodItem
        ivFoodDetails.setImageResource(item.img)
        tvFoodDetailsName.text = item.name
        tvFoodDetailsDesc.text = item.desc
    }
}