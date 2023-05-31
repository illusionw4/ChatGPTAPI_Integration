package com.asthana.foodrecipe

import android.content.Context
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterClass(private val context: Context, val reslist: ArrayList<MessageModel>) :
    RecyclerView.Adapter<AdapterClass.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClass.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemcard, parent, false)
        return MyViewHolder(itemView)    }

    override fun onBindViewHolder(holder: AdapterClass.MyViewHolder, position: Int) {
        val currentitem = reslist[position]
        if(currentitem.sentBy.equals(MessageModel.SENT_BY_ME)){
            holder.startchatview.visibility = View.GONE
            holder.userchatview.visibility = View.VISIBLE
            holder.userchat.text = currentitem.message
        }
        else{
            holder.startchatview.visibility = View.VISIBLE
            holder.userchatview.visibility = View.GONE
            holder.chatgptchat.text = currentitem.message
        }
    }

    override fun getItemCount(): Int {
        Log.d("asth", reslist.size.toString())
        return reslist.size
        }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val startchatview: LinearLayout = itemView.findViewById(R.id.startchatview)
        val userchatview: LinearLayout = itemView.findViewById(R.id.userchatview)
        val userchat: TextView = itemView.findViewById(R.id.userchat)
        val chatgptchat: TextView = itemView.findViewById(R.id.chatgptchat)
    }
}
