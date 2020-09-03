package com.examplelogin.bottom_nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View =  inflater.inflate(R.layout.fragment_recycler_view, container, false)
        val exampleList = generateDummyList(11)
        var rcy = view.findViewById<RecyclerView>(R.id.rcy)
        rcy.adapter = RecyclerViewAdapter(exampleList)
        rcy.layoutManager = GridLayoutManager(context,2)
        rcy.setHasFixedSize(true)
        return view
    }

    private fun generateDummyList(size: Int): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        val fruitNames = arrayOf("apple","avocado","banana","citrus","kiwi","orange","peach","pear","pineapple","plum","watermelon")
        for (i in 0 until size) {
            val drawable = when (i % 11) {
                0 -> R.drawable.apple
                1 -> R.drawable.avocado
                2 -> R.drawable.banana
                3 -> R.drawable.citrus
                4 -> R.drawable.kiwi
                5 -> R.drawable.orange
                6 -> R.drawable.peach
                7 -> R.drawable.pear
                8 -> R.drawable.pineapple
                9 -> R.drawable.plum
                else -> R.drawable.watermelon
            }
            val item = ExampleItem(drawable, fruitNames[i],"Item $i")
            list += item
        }
        return list
    }
}

