package com.example.matchittryhard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.matchittryhard.adapter.PositionAdapter
import com.example.matchittryhard.databinding.FragmentHomeBinding
import com.example.matchittryhard.viewModel.HomeViewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var positionsAdapter: PositionAdapter
    lateinit var viewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentHomeBinding.bind(view)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        positionsAdapter = PositionAdapter()
        prepareAdapter()

        viewModel.getPositions()

        viewModel.positions.observe(viewLifecycleOwner) { positions ->
            positionsAdapter.setPositions(ArrayList(positions))
        }

        positionsAdapter.setOnItemClickListener {
            val action =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it)
            Navigation.findNavController(binding.root).navigate(action)

        }
    }

    private fun prepareAdapter() {
        binding.rv.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = positionsAdapter
        }
    }


}