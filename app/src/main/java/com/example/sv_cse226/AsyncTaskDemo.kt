package com.example.sv_cse226

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.ProgressBar
import android.widget.Toast

class AsyncTaskDemo : AppCompatActivity() {
    lateinit var pb: ProgressBar
    lateinit var lv: ListView
    var ar = arrayOf("1","2","3","4","5","6","7","8","9","10")
    lateinit var ad:ArrayAdapter<String>
    lateinit var al:ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_demo)
        pb = findViewById(R.id.pb)
        lv = findViewById(R.id.lv)
        al = ArrayList()
        ad = ArrayAdapter(this,android.R.layout.simple_list_item_1,al)
        lv.adapter = ad
        MyTaskDemo().execute()
    }
    internal inner class MyTaskDemo: AsyncTask<Void, Int?, String?>(){
        var count = 0
        override fun onPreExecute() {
            super.onPreExecute()
            pb.max = 10
            pb.progress = 0
            pb.visibility = View.VISIBLE
            count = 0
        }
        override fun doInBackground(vararg p0: Void?): String? {
            for(i in 1..10){
                count = count + 1
                publishProgress(i)
                try {
                    Thread.sleep(1000)
                }
                catch (e:java.lang.Exception)
                {
                    e.printStackTrace()
                }
            }
            return "Task Complete"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            //super.onProgressUpdate(*values)
            pb.progress = values[0]!!
            al.add(ar[count-1])
            ad.notifyDataSetChanged()
        }

        override fun onPostExecute(result: String?) {
            //super.onPostExecute(result)
            Toast.makeText(this@AsyncTaskDemo,result,Toast.LENGTH_LONG).show()
            pb.visibility = View.INVISIBLE
        }

    }
}