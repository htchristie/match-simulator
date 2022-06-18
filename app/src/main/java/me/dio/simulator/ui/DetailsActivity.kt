package me.dio.simulator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import me.dio.simulator.databinding.ActivityDetailBinding
import me.dio.simulator.domain.Match

class DetailsActivity : AppCompatActivity() {

    object Extras {
        const val MATCH = "EXTRA_MATCH"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        loadMatchFromExtras()
    }

    private fun loadMatchFromExtras() {
        intent?.extras?.getParcelable<Match>(Extras.MATCH)?.let {
            Glide.with(this).load(it.stadium.image).into(binding.ivPlace)
            supportActionBar?.title = it.stadium.name

            Glide.with(this).load(it.homeTeam.image).into(binding.ivHomeTeam)
            Glide.with(this).load(it.guestTeam.image).into(binding.ivGuestTeam)

            binding.tvHomeTeamName.text = it.homeTeam.name
            binding.tvGuestTeamName.text = it.guestTeam.name

            binding.rbHomeTeamStars.rating = it.homeTeam.strength.toFloat()
            binding.rbGuestTeamStars.rating = it.guestTeam.strength.toFloat()

            if (it.homeTeam.Score != null) {
                binding.tvHomeTeamScore.text = it.homeTeam.Score.toString()
            }

            if (it.guestTeam.Score != null) {
                binding.tvGuestTeamScore.text = it.guestTeam.Score.toString()
            }

            binding.tvDescription.text = it.description


        }
    }
}