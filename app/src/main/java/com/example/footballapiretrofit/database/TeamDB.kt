package com.example.footballapiretrofit.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.footballapiretrofit.models.Team

@Database(entities=[Team::class],version=1)

abstract class TeamDB: RoomDatabase(){
    abstract fun getTeamDAO():TeamDAO
    //here we create the database
    companion object {
        private var INSTANCE: TeamDB?=null

        fun getInstance(context: Context):TeamDB{
            if(INSTANCE==null){
                INSTANCE=Room
                    .databaseBuilder(context,TeamDB::class.java,"team.db")
                    .allowMainThreadQueries()
                    .build()
            }
            //return the database
            return INSTANCE as TeamDB
        }
    }
}





























