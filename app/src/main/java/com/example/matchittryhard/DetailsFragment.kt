package com.example.matchittryhard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.matchittryhard.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailsBinding.bind(view)

        val position = args.positionDetails

        Glide.with(this).load(position.picture).into(binding.imageView)
        binding.tvName.text = position.name
        binding.tvDescription.text = "Opis pozicije: ${position.description}"
        binding.tvTechnologies.text = "Trazene tehnologije: ${position.technologies}"
        binding.tvSalaryRange.text = "Rang plate: ${position.salaryRange}"
        binding.tvAbout.text = position.about


    }
}