package com.skreep.cleanarchitectureproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skreep.cleanarchitectureproject.R
import com.skreep.cleanarchitectureproject.data.repository.UserRepositoryImp
import com.skreep.cleanarchitectureproject.databinding.ActivityMainBinding
import com.skreep.cleanarchitectureproject.domain.models.GetUserName
import com.skreep.cleanarchitectureproject.domain.repository.UserRepository
import com.skreep.cleanarchitectureproject.domain.usecases.GetUserNameUseСase

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val userRepository by lazy { UserRepositoryImp(context = applicationContext)}
    private val getUserNameUseСase by lazy { GetUserNameUseСase(userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.apply {
            getButton.setOnClickListener {
                //button get
                val name = etName.text.toString()
                val params = GetUserName(name = name)
                val result: String = getUserNameUseСase.excecute(getUserName = params)
                tvName.text = "Твое имя $result"


            }
        }




    }
}