package com.rssoft.zoo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rssoft.zoo.models.Animal
import kotlinx.android.synthetic.main.activity_animal_info.*
import java.util.*

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)
        val b: Bundle = intent.extras!!
        val animal: Animal = b.get("animal") as Animal
        ivAnimal.setImageResource(animal.img)
        tvAnimalNameInfo.text = animal.name.toUpperCase(Locale.getDefault())
        tvAnimalDescInfo.text = animal.desc
        if(animal.endangered){
            tvAnimalNameInfo.setTextColor(Color.RED)
        }
    }
}