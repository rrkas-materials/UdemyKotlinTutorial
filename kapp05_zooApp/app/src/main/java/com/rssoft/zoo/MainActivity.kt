package com.rssoft.zoo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.rssoft.zoo.models.Animal
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_row.view.*
import kotlinx.android.synthetic.main.animal_row.view.ivAnimal
import kotlinx.android.synthetic.main.animal_row.view.tvAnimalName

class MainActivity : AppCompatActivity() {

    private val animals = arrayListOf<Animal>()
    private var adapter: AnimalsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadAnimals()
        adapter = AnimalsAdapter(animals)
        listViewAnimal.adapter = adapter
    }

    private fun loadAnimals() {
        animals.add(Animal("Baboon", "A kind of money", R.drawable.baboon, true))
        animals.add(Animal("Bull Dog", "A kind of dog", R.drawable.bulldog, false))
        animals.add(Animal("Swallow Bird", "A kind of small bird", R.drawable.swallow_bird, false))
        animals.add(Animal("Panda", "A back and white bear like animal", R.drawable.panda, true))
        animals.add(
            Animal(
                "White Tiger",
                "A rare member of tiger family",
                R.drawable.white_tiger,
                true
            )
        )
        animals.add(Animal("Zebra", "A back and white horse like animal", R.drawable.zebra, false))
    }

    fun deleteAnimal(idx: Int) {
        animals.removeAt(idx)
        adapter!!.notifyDataSetChanged()
    }

    fun addAnimal(idx: Int) {
        animals.add(idx, animals[idx])
        adapter!!.notifyDataSetChanged()
    }

    inner class AnimalsAdapter(private val animals: ArrayList<Animal>) : BaseAdapter() {
        override fun getCount(): Int {
            //returns count of the list view
            //determines how many times to replicate
            return animals.size
        }

        override fun getItem(idx: Int): Any {
            //gives the adapter the data to put in view
            return animals[idx]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        @SuppressLint("InflateParams", "ViewHolder")
        override fun getView(idx: Int, view: View?, vg: ViewGroup?): View {
            //gives the adapter the view to put
            val animal = animals[idx]
            val myView =
                if (!animal.endangered)
                    LayoutInflater.from(vg!!.context).inflate(R.layout.animal_row, null)
                else
                    LayoutInflater.from(vg!!.context).inflate(R.layout.animal_row_endangered, null)
            myView.tvAnimalName.text = animal.name
            myView.tvAnimalDesc.text = animal.desc
            myView.ivAnimal.setImageResource(animal.img)
            myView.setOnClickListener {
                val intent = Intent(myView.context, AnimalInfo::class.java)
                intent.putExtra("animal", animal)
                myView.context.startActivity(intent)
            }
            myView.buttonDeleteAnimal.setOnClickListener {
                deleteAnimal(idx)
            }
            myView.buttonDuplicateAnimal.setOnClickListener {
                addAnimal(idx)
            }
            return myView
        }
    }
}