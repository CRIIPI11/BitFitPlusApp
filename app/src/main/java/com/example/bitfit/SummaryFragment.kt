package com.example.bitfit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.json.JSONException
import org.w3c.dom.Text


class SummaryFragment : Fragment() {

    private var avg = ""
    private var min = ""
    private var max = ""
    private lateinit var avg1:TextView
    private lateinit var max1:TextView
    private lateinit var min1:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sumary, container, false)
        avg1 = view.findViewById<TextView>(R.id.avg)
        min1 = view.findViewById<TextView>(R.id.min)
        max1 = view.findViewById<TextView>(R.id.max)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated
        lifecycleScope.launch(Dispatchers.IO) {
            avg =  ((requireActivity().application as FoodApplication).db.foodDao().getAvg()).toString()
            min =  ((requireActivity().application as FoodApplication).db.foodDao().getMin()).toString()
            max =  ((requireActivity().application as FoodApplication).db.foodDao().getMax()).toString()

            avg1.text = "Total Calories: "+avg
            min1.text = "Min Calories: "+min
            max1.text = "Max Calories: "+max
            Log.d("value", avg)
        }

    }

    companion object {
        fun newInstance(): FoodFragment {
            return FoodFragment()
        }
    }
}





