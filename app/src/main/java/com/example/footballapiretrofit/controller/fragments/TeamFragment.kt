package com.example.footballapiretrofit.controller.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapiretrofit.R
import com.example.footballapiretrofit.adapter.TeamAdapter
import com.example.footballapiretrofit.controller.activities.TeamDetail
import com.example.footballapiretrofit.models.ApiResponseHeader
import com.example.footballapiretrofit.models.Team
import com.example.footballapiretrofit.network.TeamService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TeamFragment : Fragment(), TeamAdapter.OnItemClickListener {

    var team: List<Team> =ArrayList()

    lateinit var recyclerView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView =view.findViewById(R.id.rvTeams)
        loadTeams(view.context)

    }


    private fun loadTeams(context: Context){
        val retrofit= Retrofit.Builder()
            .baseUrl("https://api-football-v1.p.rapidapi.com/v2/teams/league/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val teamService: TeamService
        teamService=retrofit.create(TeamService::class.java)

        val request=teamService.getTeams(
            host="api-football-v1.p.rapidapi.com",
            apikey="e5e0962b88mshce8e2745d9a7d43p1b873djsn84e633c70bf3"
        )

        request.enqueue(object: Callback<ApiResponseHeader> {
            override fun onResponse(
                call: Call<ApiResponseHeader>,
                response: Response<ApiResponseHeader>
            ) {
                //if there's no error
                if(response.isSuccessful){
                    val teams:List<Team> = response.body()!!.api.teams ?: ArrayList()
                    recyclerView.adapter= TeamAdapter(teams,context,this@TeamFragment)
                    recyclerView.layoutManager= LinearLayoutManager(context)
                }else{
                    Log.d("Activity Fail","Error"+response.code())
                }
            }

            override fun onFailure(call: Call<ApiResponseHeader>, t: Throwable) {
                //if there's an error
                Log.d("Activity Fail","Error"+t.toString())
            }

        })

    }

    override fun onItemClicked(team: Team) {
        val intent=Intent(context,TeamDetail::class.java)
        intent.putExtra("Team",team)
        startActivity(intent)
    }

}


















