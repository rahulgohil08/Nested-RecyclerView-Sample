package com.theworld.androidtemplatewithnavcomponents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.theworld.androidtemplatewithnavcomponents.databinding.ActivityLoginBinding
import com.theworld.androidtemplatewithnavcomponents.databinding.ActivityMainBinding
import com.theworld.androidtemplatewithnavcomponents.utils.*
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    companion object {
        private const val TAG = "LoginActivity"
    }

    private lateinit var binding: ActivityLoginBinding
    private val context = this

    private val pattern by lazy { "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{6,8}\$" }


    @Inject
    lateinit var sharedPrefManager: SharedPrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {


        binding.apply {

            edtMobileNo.editText!!.setText("1234567890")
            edtPassword.editText!!.setText("aA@123")

            btnLogin.setOnClickListener {
                if (!edtMobileNo.customValidation(
                        CustomValidation()
                    )
                    or
                    !edtPassword.customValidation(
                        CustomValidation()
                    )
                ) {
                    return@setOnClickListener
                }


                if(!Regex(pattern).matches(edtPassword.normalText())){
                    edtPassword.error = "Password should have at least one special character with lower, upper case and number"
                    return@setOnClickListener
                }

                sharedPrefManager.setBoolean("is_login", true)
                startNewActivity(MainActivity::class.java)

            }

        }
    }
}