package com.example.sv_cse226

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listView: ListView = findViewById(R.id.listView)
        var list= mutableListOf<ContactDataModelClass>()
        list.add(ContactDataModelClass("Nisha","123456",R.drawable.ic_launcher_foreground,checked=false))
        list.add(ContactDataModelClass("Nia","123456",R.drawable.ic_launcher_foreground,checked=false))
        list.add(ContactDataModelClass("Nis","123456",R.drawable.ic_launcher_foreground,checked=false))
        listView.adapter=CustomListViewDemo(this,R.layout.custom_list_view_xml,list)
    }
}