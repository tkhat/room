package com.raywenderlich.training_with_room.ui.addUserFragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.raywenderlich.training_with_room.R
import com.raywenderlich.training_with_room.dataStorage.User
import com.raywenderlich.training_with_room.databinding.AddUserFragmentBinding
import com.raywenderlich.training_with_room.databinding.UserItemBinding
import com.raywenderlich.training_with_room.ui.userfragment.UserViewModel

class AddUserFragment : Fragment() {



    private lateinit var binding: AddUserFragmentBinding

    private val viewModel: AddUserViewModel by viewModels()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AddUserFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener{

            binding.apply {
                if(checkData()){

                    viewModel.put(makeUser())

                }else{
                    makeText("fill all text")
                }
            }


        }

    }

    private fun checkData():Boolean{
       return (!binding.editTextFirstname.text.isNullOrBlank() &&
            !binding.editTextLastName.text.isNullOrBlank() &&
            !binding.editTextAge.text.isNullOrBlank()&&
            !binding.editTextAddress.text.isNullOrBlank()&&
            !binding.editTextHeight.text.isNullOrBlank()&&
            !binding.profileEditText.text.isNullOrBlank())
    }

    private fun makeUser():User{

        return User(binding.editTextFirstname.text.toString(),
            binding.editTextLastName.text.toString(),
        binding.editTextAge.text.toString().toInt(),
        binding.editTextAddress.text.toString(),
        binding.editTextHeight.text.toString().toDouble(),
        binding.profileEditText.text.toString())

    }


    private fun makeText(str: String){
        Toast.makeText(requireContext(),str,Toast.LENGTH_SHORT).show()
    }




}