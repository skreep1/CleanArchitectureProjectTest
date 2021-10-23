package com.skreep.cleanarchitectureproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.skreep.cleanarchitectureproject.data.repository.UserRepositoryImp
import com.skreep.cleanarchitectureproject.databinding.ActivityMainBinding
import com.skreep.cleanarchitectureproject.domain.models.GetUserName
import com.skreep.cleanarchitectureproject.domain.models.SaveUser
import com.skreep.cleanarchitectureproject.domain.usecases.GetUserNameUseСase
import com.skreep.cleanarchitectureproject.domain.usecases.SaveUserNameUseCase


const val TOAST_SAVE_TEXT = "Вы успешно сохранили"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val userRepository by lazy { UserRepositoryImp(context = applicationContext)}
    private val saveUserNameUseСase by lazy { SaveUserNameUseCase(userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.apply {
            saveButton.setOnClickListener {
                Toast.makeText(applicationContext, TOAST_SAVE_TEXT, Toast.LENGTH_SHORT ).show()
                val text = etName.text.toString()
                val params = SaveUser(name = text)
                val result: String = saveUserNameUseСase.execute(param = params)
                tvName.text = "Save Result $result"


            }
        }




    }
}