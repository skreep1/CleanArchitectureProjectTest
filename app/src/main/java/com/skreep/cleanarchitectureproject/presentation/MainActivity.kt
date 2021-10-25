package com.skreep.cleanarchitectureproject.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    lateinit var binding: ActivityMainBinding

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImp(userStorage = SharedPrefUserStorage(context = applicationContext))}

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)}

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseСase(userRepository = userRepository)}

    private val clearUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        ClearUserNameUseCase(userRepository = userRepository)}

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
                val result: String = saveUserNameUseCase.execute(paramSave = params)
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