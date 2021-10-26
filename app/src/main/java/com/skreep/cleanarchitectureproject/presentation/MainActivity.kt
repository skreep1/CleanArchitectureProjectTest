package com.skreep.cleanarchitectureproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.skreep.data.repository.UserRepositoryImp
import com.skreep.cleanarchitectureproject.databinding.ActivityMainBinding
import com.skreep.data.storage.sharedprefs.SharedPrefUserStorage
import com.skreep.domain.models.ClearUser
import com.skreep.domain.models.GetUserName
import com.skreep.domain.models.SaveUser
import com.skreep.domain.usecases.ClearUserNameUseCase
import com.skreep.domain.usecases.GetUserNameUseСase
import com.skreep.domain.usecases.SaveUserNameUseCase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this, MainViewModelFactory(this)
        )[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //подписка на изменение данных
        viewModel.livedata.observe(this, Observer {
            binding.tvName.text = it
        })


        binding.apply {
            // save button
            saveButton.setOnClickListener {
                val text = etName.text.toString()
               viewModel.save(text = text)
            }
        }

        binding.apply {
            //get button
            getButton.setOnClickListener {
                viewModel.load()
            }
        }

        binding.apply {
            //clear button
            clearButton.setOnClickListener {
                val text = etName.text.toString()
               viewModel.clear(text = text)
            }
        }


    }
}