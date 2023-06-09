package com.example.footballapiretrofit.controller.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapiretrofit.R
import com.example.footballapiretrofit.adapter.TeamAdapter
import com.example.footballapiretrofit.controller.fragments.SaveFragment
import com.example.footballapiretrofit.controller.fragments.TeamFragment
import com.example.footballapiretrofit.models.ApiResponseHeader
import com.example.footballapiretrofit.models.Team
import com.example.footballapiretrofit.network.TeamService
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener=BottomNavigationView.
        OnNavigationItemSelectedListener{item->navigateTo(item)}

    private fun navigateTo(item: MenuItem):Boolean{
        item.isChecked=true
        return supportFragmentManager
            .beginTransaction()
            .replace(R.id.flFragment,getFragmentFor(item))
            .commit()>0
    }
    private fun getFragmentFor(item:MenuItem): Fragment {
        return when(item.itemId){
            R.id.menu_home->TeamFragment()
            R.id.menu_favourite->SaveFragment()
            else -> TeamFragment()
        }

    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView=findViewById(R.id.bnvMenu )
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigateTo(navView.menu.findItem(R.id.menu_home))




    }


}






















