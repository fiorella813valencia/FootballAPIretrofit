package com.example.footballapiretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.footballapiretrofit.R
import com.example.footballapiretrofit.models.Team
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso

class TeamAdapter(val teams: List<Team>, val context:Context, val itemClickListener: OnItemClickListener): RecyclerView.Adapter<TeamAdapter.ViewHolder> () {
    class ViewHolder (val view: View): RecyclerView.ViewHolder(view){
        val ivLogo=view.findViewById<ImageView>(R.id.ivLogo)
        val tvName=view.findViewById<TextView>(R.id.tvName)
        val cvTeam=view.findViewById<CardView>(R.id.cvTeams)

    }
    interface OnItemClickListener {
        fun onItemClicked(team:Team)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamAdapter.ViewHolder {
        val view =LayoutInflater.from(context)
            .inflate(R.layout.prototype_team,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamAdapter.ViewHolder, position: Int) {
        //load name
        val team=teams[position]
        holder.tvName.text=team.name
        //load image
        val picBuilder= Picasso.Builder(context)
        picBuilder.downloader(OkHttp3Downloader(context))
        picBuilder.build().load(team.logo)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(holder.ivLogo)

        holder.cvTeam.setOnClickListener{
            itemClickListener.onItemClicked(team)
        }

    }

    override fun getItemCount(): Int {
        return teams.size
    }
}

























