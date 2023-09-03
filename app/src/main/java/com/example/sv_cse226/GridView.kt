package com.example.sv_cse226

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridView : AppCompatActivity() {
    lateinit var arrayList:ArrayList<GridModel>
    lateinit var recyclerView:RecyclerView
    var adapterRecycler:MyAdapterGrid?=null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)
        gridListData()
        recyclerView=findViewById(R.id.recyclerGrid)
        recyclerView.setHasFixedSize(true)
        val griLayoutManager=GridLayoutManager(this,2)
        griLayoutManager.orientation=RecyclerView.VERTICAL
        recyclerView.setLayoutManager(griLayoutManager)
        adapterRecycler= MyAdapterGrid(this,arrayList)
        recyclerView.setAdapter(adapterRecycler)
    }

    private fun gridListData() {
        arrayList=ArrayList<GridModel>()
        arrayList.add(GridModel("Mobile",R.drawable.ic_launcher_smartphone_foreground))
        arrayList.add(GridModel("Internet",R.drawable.ic_launcher_smartphone_foreground))
        arrayList.add(GridModel("Wifi",R.drawable.ic_launcher_smartphone_foreground))
        arrayList.add(GridModel("Database",R.drawable.ic_launcher_smartphone_foreground))
        arrayList.add(GridModel("Battery",R.drawable.ic_launcher_smartphone_foreground))
    }
}