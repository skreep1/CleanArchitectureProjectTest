package com.skreep.cleanarchitectureproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skreep.cleanarchitectureproject.data.repository.UserRepositoryImp
import com.skreep.cleanarchitectureproject.databinding.ActivityMainBinding
import com.skreep.cleanarchitectureproject.domain.models.ClearUser
import com.skreep.cleanarchitectureproject.domain.models.GetUserName
import com.skreep.cleanarchitectureproject.domain.models.SaveUser
import com.skreep.cleanarchitectureproject.domain.usecases.ClearUserNameUseCase
import com.skreep.cleanarchitectureproject.domain.usecases.GetUserNameUseСase
import com.skreep.cleanarchitectureproject.domain.usecases.SaveUserNameUseCase



class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val userRepository by lazy { UserRepositoryImp(context = applicationContext)}
    private val saveUserNameUseСase by lazy { SaveUserNameUseCase(userRepository = userRepository)}
    private val getUserNameUseCase by lazy { GetUserNameUseСase(userRepository = userRepository)}
    private val clearUserNameUseCase by lazy { ClearUserNameUseCase(userRepository = userRepository)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.apply {
            // save button
            saveButton.setOnClickListener {
                val text = etName.text.toString()
                val params = SaveUser(savename = text)
                val result: String = saveUserNameUseСase.execute(paramSave = params)
                tvName.text = result


            }
        }

        binding.apply {
            //get button
            getButton.setOnClickListener {
                val username: GetUserName = getUserNameUseCase.execute()
                tvName.text = "${username.name}"
            }
        }

        binding.apply {
            //clear button
            clearButton.setOnClickListener {
                val text = etName.text.toString()
                val params = ClearUser(clearUser = text)
                val result: String = clearUserNameUseCase.execute(clearUser = params)
                tvName.text = result
            }
        }




    }
}