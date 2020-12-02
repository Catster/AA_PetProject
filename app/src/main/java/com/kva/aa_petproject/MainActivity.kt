package com.kva.aa_petproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kva.aa_petproject.data.Movie
import com.kva.aa_petproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentMoviesListListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onClick(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(
                    R.id.fragment_container_view,
                    FragmentMovieDetails.newInstance(movie)
                )
                addToBackStack(null)
                commit()
            }
    }
}