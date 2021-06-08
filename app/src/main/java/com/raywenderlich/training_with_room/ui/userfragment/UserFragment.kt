package com.raywenderlich.training_with_room.ui.userfragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.raywenderlich.training_with_room.R
import com.raywenderlich.training_with_room.UserListener
import com.raywenderlich.training_with_room.databinding.UserFragmentBinding

class UserFragment : Fragment() {





    private var binding :UserFragmentBinding? = null

    private lateinit var adapter: UserAdapter

    private val viewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{

        if (binding == null){
            binding = UserFragmentBinding.inflate(inflater,container,false)

        }
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.addUserButton?.setOnClickListener{
            findNavController().navigate(R.id.action_userFragment2_to_addUserFragment)
        }
        initRec()

    }

    private fun initRec(){
        adapter = UserAdapter(object : UserListener{
            override fun delteUser(position: Int) {
                viewModel.deleteUser(user = adapter.userList[position])
                adapter.notifyItemRemoved(position)
            }

        })
        viewModel.showUser()
        viewModel.users.observe(viewLifecycleOwner){

            adapter.setData(it)
        }
        binding?.recyclerview?.layoutManager = GridLayoutManager(requireContext(),1)
        binding?.recyclerview?.adapter = adapter


    }




}