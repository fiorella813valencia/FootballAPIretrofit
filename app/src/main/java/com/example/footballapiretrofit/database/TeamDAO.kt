package com.example.footballapiretrofit.database

import androidx.room.*
import com.example.footballapiretrofit.models.Team

@Dao
interface TeamDAO {
    @Insert
    fun insertTeam(vararg  team:Team)

    @Query("SELECT * FROM teams")
    fun getAllTeams():List<Team>

    @Delete
    fun deleteTeams(vararg team:Team)

    @Update
    fun updateTemas(vararg team:Team)

}

























