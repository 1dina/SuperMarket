package com.example.supermarket

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room.databaseBuilder
import kotlin.math.log


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView :RecyclerView
    var arrayList :ArrayList<SuperMarketModel> =ArrayList()
    val adapter = SuperMarketAdapter()
    private var arrayItemName = arrayOf("Apple","Pineapple","Banana","Peach","Eggs","Tea","Sugar","Milk")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val database = databaseBuilder(applicationContext, ItemsDatabase::class.java, "ItemsDB")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        var counter=0
        while(counter!=arrayItemName.size){
           val superMarketModel = SuperMarketModel(arrayItemName[counter])
            database.itemsDao.insertItems(superMarketModel)
            counter++
        }
          arrayList.addAll(database.itemsDao.getItems())

        Log.d("TAG",database.toString())
        setUpRV()

    }

    private fun setUpRV (){
        recyclerView= findViewById(R.id.recycle_view)
        recyclerView.adapter=adapter
        recyclerView.layoutManager=LinearLayoutManager(this)

    }
}

