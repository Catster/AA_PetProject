package com.kva.aa_petproject

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kva.aa_petproject.databinding.ActivityMainBinding
import kotlinx.android.parcel.Parcelize


const val INTENT_NAME_KEY = "name"
const val SECRET_PASSWORD = "1234"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener { login() }
    }


    private fun login() {
        if (binding.loginEt.text.isEmpty()) {
            Toast.makeText(this, getString(R.string.login_empty_error), Toast.LENGTH_LONG).show()
            return
        }

        if (binding.passwordEt.text.toString() == SECRET_PASSWORD) {
            val user = User(binding.loginEt.text.toString())
            val intent = Intent(this, NameActivity::class.java)
            intent.putExtra(INTENT_NAME_KEY, user)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, getString(R.string.wrong_password_error), Toast.LENGTH_LONG).show()
        }
    }
}

@Parcelize
data class User(val name: String) : Parcelable {

}