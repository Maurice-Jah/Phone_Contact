package com.example.phonecontact.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.phonecontact.R
import com.example.phonecontact.model.AlphaChar

class AlphaAdapters(var context: Context, var arrayList: ArrayList<AlphaChar>,
private val listener: OnItemClickListener
                    ):RecyclerView.Adapter<AlphaAdapters.ItemHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder{
       val itemHolder =LayoutInflater.from(parent.context).inflate(R.layout.grid_layout_list_item, parent, false)



        return ItemHolder(itemHolder)

    }



    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
       var alphaChar:AlphaChar = arrayList.get(position)
        holder.icons.setImageResource(alphaChar.iconsChar!!)
        holder.alphas.text = alphaChar.alphaChar

        holder.alphas.setOnClickListener {
            Toast.makeText(context, alphaChar.alphaChar, Toast.LENGTH_SHORT).show()
        }





    }

    override fun getItemCount(): Int {
       return arrayList.size
    }

   inner class ItemHolder(itemView:View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var icons:ImageView = itemView.findViewById<ImageView>(R.id.icons_image)
        var alphas: TextView = itemView.findViewById<TextView>(R.id.group_title)


        init {
            itemView.setOnClickListener(this)
        }



       override fun onClick(v: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}