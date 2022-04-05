package com.example.cleancodekotlin.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cleancodekotlin.R
import com.example.cleancodekotlin.model.RetrofitClient
import com.example.cleancodekotlin.network.APIServices
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    var context : Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_list.setOnClickListener {
//             getListFromServer()
             get401ErrorServer()

        }


        context  = this@MainActivity

    }

    private fun get401ErrorServer() {
        val request = RetrofitClient().buildService(APIServices::class.java , context)
        val  call = request.get401List(0)

        call?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.isSuccessful) {

                    Log.i("TAG", "onResponse: ")

                } else {
                    Log.i("TAG", "onResponse: ")
                }

            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                Log.i("TAG", "onResponse: ")
            }
        })
    }


    private fun getListFromServer() {

        val request = RetrofitClient().buildService(APIServices::class.java , context)
        val  call = request.getUserList()

        call?.enqueue(object : Callback<JsonArray?> {
            override fun onResponse(call: Call<JsonArray?>, response: Response<JsonArray?>) {
                if (response.isSuccessful) {

                    Log.i("TAG", "onResponse: ")

                } else {
                    Log.i("TAG", "onResponse: ")
                }

            }

            override fun onFailure(call: Call<JsonArray?>, t: Throwable) {
                Log.i("TAG", "onResponse: ")
            }
        })


    }
}

