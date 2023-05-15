package com.example.footballapiretrofit.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(
    tableName="teams"
)

class Team(
    @PrimaryKey
    @SerializedName("team_id")
    var team_id:Int=0,

    @SerializedName("name")
    var name:String,

    @SerializedName("logo")
    var logo:String,

    @SerializedName("venue_name")
    val venueName:String
): Serializable










































