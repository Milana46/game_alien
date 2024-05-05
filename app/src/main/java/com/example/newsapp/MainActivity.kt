package com.example.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MainDb.getDb(this)
        db.getDao().getAllItems().asLiveData().observe(this){
            binding.tvList.text=""
            it.forEach {
                val text = "Id:${it.id} Name:${it.name} Price:${it.price}\n"
                binding.tvList.append(text)
            }


        }



        binding.btnSave.setOnClickListener {
            //обычный экземпляр класса!!!
            val item = ItemEntity(null, binding.edName.text.toString(), binding.edPrice.text.toString())
            Thread {
                db.getDao().insertItem(item)
            }.start()
        }
    }
}
