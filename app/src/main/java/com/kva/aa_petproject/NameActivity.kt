package com.kva.aa_petproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kva.aa_petproject.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = intent.extras
        val user = bundle?.getParcelable<User>(INTENT_NAME_KEY)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_name)
        binding.user = user
    }

}