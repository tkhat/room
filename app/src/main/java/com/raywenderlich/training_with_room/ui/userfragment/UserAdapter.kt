package com.raywenderlich.training_with_room.ui.userfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.training_with_room.UserListener
import com.raywenderlich.training_with_room.dataStorage.User
import com.raywenderlich.training_with_room.databinding.UserFragmentBinding
import com.raywenderlich.training_with_room.databinding.UserItemBinding

class UserAdapter(private val userListener: UserListener):RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    var userList: List<User> = emptyList()


    fun setData(list: List<User>){
        userList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        return ViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount()=userList.size

    inner class ViewHolder(private val binding: UserItemBinding):RecyclerView.ViewHolder(binding.root),View.OnClickListener{
        private lateinit var user: User
        fun bind(){
            user  = userList[adapterPosition]

            binding.apply {
                firstName.text = user.firstName
                lastName.text = user.lastName
                age.text = user.age.toString()
                address.text = user.address
                height.text = user.height.toString()
                profile.text = user.profile
            }


            binding.deleteButton.setOnClickListener(this)


        }

        override fun onClick(v: View?) {
            if (v == binding.deleteButton){
                userListener.delteUser(adapterPosition)
            }
        }
    }


}