package com.example.bitfit
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SummaryAdapter(private val context: Context, private val foods: List<Food>) :
    RecyclerView.Adapter<SummaryAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_sumary, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foods[position]
        holder.bind(food)
    }

    override fun getItemCount() = foods.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val foodnametxt = itemView.findViewById<TextView>(R.id.foodname)
        private val caloriestxt = itemView.findViewById<TextView>(R.id.calnum)

        fun bind(fd: Food) {
            foodnametxt.text = fd.name
            caloriestxt.text = fd.calories.toString()

        }

    }


}