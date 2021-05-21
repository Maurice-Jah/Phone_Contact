package com.example.phonecontact

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.phonecontact.adapters.AlphaAdapters
import com.example.phonecontact.model.AlphaChar


class MainActivity : AppCompatActivity(), AlphaAdapters.OnItemClickListener {

    private var recyclerView:RecyclerView ? = null
    private var gridLayoutManager : GridLayoutManager ? = null
    private var arrayList: ArrayList<AlphaChar> ? = null
    private var alphaAdapters : AlphaAdapters ? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        gridLayoutManager = GridLayoutManager(this,2)
        recyclerView?.layoutManager = gridLayoutManager
        recyclerView?.setHasFixedSize(true)
        arrayList = ArrayList()
        arrayList = setDataInList()
        alphaAdapters = AlphaAdapters(applicationContext,arrayList!!,this)
        recyclerView?.adapter = alphaAdapters





    }

    override fun onItemClick(position: Int) {
        val intent = Intent(this,GroupContacts::class.java)
        startActivity(intent)


    }



    private fun setDataInList() : ArrayList<AlphaChar>{
        val items: ArrayList<AlphaChar> = ArrayList()

        items.add(AlphaChar(R.drawable.ic_baseline_family,  "Family"))
        items.add(AlphaChar(R.drawable.ic_baseline_people_24,  "Friends"))
        items.add(AlphaChar(R.drawable.ic_baseline_account_circle_24,  "Tutor"))
        items.add(AlphaChar(R.drawable.ic_baseline_people_colleague,  "Colleague"))


        return items

    }
}



