package com.example.footballapiretrofit.controller.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.footballapiretrofit.R
import com.example.footballapiretrofit.database.TeamDB
import com.example.footballapiretrofit.models.Team
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class TeamDetail : AppCompatActivity() {



    lateinit var ivLogoDetail:ImageView
    lateinit var tvNameDetail: TextView
    lateinit var tvVenueDetail: TextView
    lateinit var fabSave:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        ivLogoDetail=findViewById(R.id.ivLogoDetail)
        tvNameDetail=findViewById(R.id.tvNameDetail)
        tvVenueDetail=findViewById(R.id.tvVenueDetail)
        fabSave=findViewById(R.id.fabSave)

        initFields(this)
    }

    private fun initFields(context:Context) {
        val teamObject: Team? = intent.getSerializableExtra("Team") as Team?

        val picBuilder= Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(teamObject?.logo).into(ivLogoDetail)
        
        tvNameDetail.text=teamObject?.name
        tvVenueDetail.text=teamObject?.venueName
        
        fabSave.setOnClickListener{
            saveTeam(teamObject)
            finish()
        }
    }

    private fun saveTeam(teamObject: Team?) {
        if(teamObject!=null){
            TeamDB.getInstance(this).getTeamDAO().insertTeam(teamObject)
        }

    }
}





















