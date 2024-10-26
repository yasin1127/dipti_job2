package com.example.userprofileregistration_dipti_15.adapter15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.userprofileregistration_dipti_15.R
import com.example.userprofileregistration_dipti_15.model15.UP15

class ProfileAdapter15 :ListAdapter<UP15, ProfileAdapter15.ProfileViewHolder>(DiffCallback()) {
    private var onItemClickListener:((UP15)->Unit)?=null
    private var onDeleteClickListener:((UP15)->Unit)?=null
    private var onEditClickListener:((UP15)->Unit)?=null


    fun setOnItemClickListener(listener: (UP15)->Unit){
        onItemClickListener=listener
    }
    fun setOnDeleteClickListener(listener: (UP15)->Unit){
        onDeleteClickListener=listener
    }
    fun setOnEditClickListener(listener: (UP15)->Unit){
        onEditClickListener=listener
    }
    fun setOnUpdateClickListener(listener: (UP15) -> Unit) {
        var onUpdateClickListener = listener
    }
    inner class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val profileName: TextView = itemView.findViewById(R.id.ntxt)
        private val profileEmail: TextView = itemView.findViewById(R.id.etxt)
        private val profileDOB: TextView = itemView.findViewById(R.id.bodtxt)
        private val profileDistrict: TextView = itemView.findViewById(R.id.Dtxt)
        private val profileMobile: TextView = itemView.findViewById(R.id.mtxt)
        private val updateBtn: ImageButton = itemView.findViewById(R.id.ebtn)
        private val deleteBtn: ImageButton = itemView.findViewById(R.id.dbtn)

        init {
            itemView.setOnClickListener{
                val position=adapterPosition
                if(position!= RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onItemClickListener?.invoke(profile)

                }
            }
            deleteBtn.setOnClickListener{
                val position=adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onDeleteClickListener?.invoke(profile)
                }

            }
            updateBtn.setOnClickListener{
                val position =adapterPosition
                if (position!=RecyclerView.NO_POSITION){
                    val profile = getItem(position)
                    onEditClickListener?.invoke(profile)
                }
            }

        }

        fun bind(up: UP15){
            profileName.text = up.name
            profileEmail.text = up.email
            profileDOB.text = up.dob
            profileDistrict.text = up.dist
            profileMobile.text = up.mobile.toString()

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileAdapter15.ProfileViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_profile_list215,parent,false)
        return ProfileViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProfileAdapter15.ProfileViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DiffCallback:DiffUtil.ItemCallback<UP15>(){
    override fun areItemsTheSame(oldItem: UP15, newItem: UP15): Boolean {
        return oldItem.id== newItem.id
    }

    override fun areContentsTheSame(oldItem: UP15, newItem: UP15): Boolean {
        return oldItem==newItem
    }


}