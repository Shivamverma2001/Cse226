package com.example.sv_cse226

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.drm.ProcessedData
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class AsyncTaskDemo2 : AppCompatActivity() {
    lateinit var ImageUrl:URL
    var `is`:InputStream?=null
    var bmImg:Bitmap?=null
    lateinit var btn:Button
    lateinit var iv:ImageView
    lateinit var p:ProgressDialog
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task_demo2)
        btn=findViewById(R.id.btn)
        iv=findViewById(R.id.iv)
        btn.setOnClickListener{
            val asyncTask:AsyncTasExample=AsyncTasExample()
            asyncTask.execute("https://www.cleverfiles.com/howto/wp-content/uploads/2018/03/minion.jpg")
        }
        }
    private inner class AsyncTasExample: AsyncTask<String?, String?, Bitmap?>(){
        override fun onPreExecute() {
            super.onPreExecute()
            p=ProgressDialog(this@AsyncTaskDemo2)
            p.setMessage("Please wait.. It is downloading")
            p.setCancelable(false)
            p.show()
        }
        override fun doInBackground(vararg p0: String?): Bitmap? {
            try{
                ImageUrl=URL(p0[0])
                val conn:HttpURLConnection=
                    ImageUrl.openConnection() as HttpURLConnection
                conn.setDoInput(true)
                conn.connect()
                `is`=conn.getInputStream()
                val options=BitmapFactory.Options()
                options.inPreferredConfig=Bitmap.Config.RGB_565
                bmImg=BitmapFactory.decodeStream(`is`,null,options)
            }catch (e:IOException){
                e.printStackTrace()
            }
            return bmImg
        }

        override fun onPostExecute(bitmap: Bitmap?) {
            super.onPostExecute(bitmap)
            if(iv!=null){
                p.hide()
                iv.setImageBitmap(bitmap)
            }else{
                p.show()
            }
        }
    }
}