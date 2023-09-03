package com.example.sv_cse226
// Custom List View Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomListViewDemo(context: Context, var resource: Int, var objects: MutableList<ContactDataModelClass>) : ArrayAdapter<ContactDataModelClass>(context, resource, objects) {

    private var c=0
    var i=0
    lateinit var cb: CheckBox
    fun isChecked(position: Int):Boolean{

        return objects.get(position).checked
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(resource, null)
        val imageView: ImageView = view.findViewById(R.id.image)
        val titleTextView: TextView = view.findViewById(R.id.textView1)
        val descTextView: TextView = view.findViewById(R.id.textView2)
        val button: Button =view.findViewById(R.id.tButton)
        cb=view.findViewById<CheckBox>(R.id.checkbx)
        val myItem: ContactDataModelClass = objects[position]
        imageView.setImageDrawable(context.resources.getDrawable(myItem.image))
        titleTextView.text = myItem.title
        descTextView.text = myItem.desc
        button.tag=position
        cb.setChecked(objects.get(position).checked)
        cb.setTag(position)
        var itemStr=objects.get(position).title
        cb.setOnClickListener(View.OnClickListener {
            val newState: Boolean=!objects.get(position).isChecked()
            objects.get(position).checked=newState
            Toast.makeText(context, itemStr+ "Selected with state : "+newState, Toast.LENGTH_LONG).show()
        })
        cb.setChecked(isChecked(position))

        button.setOnClickListener {
            val itemselected=objects.get(it.tag as Int)
            objects.remove(itemselected)
            notifyDataSetChanged()
        }
        return view
    }
    override fun getCount(): Int {
        return super.getCount()
    }



}