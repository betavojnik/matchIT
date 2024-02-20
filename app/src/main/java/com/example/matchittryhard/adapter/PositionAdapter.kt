package com.example.matchittryhard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matchittryhard.R
import com.example.matchittryhard.databinding.PositionViewBinding
import com.example.matchittryhard.model.Position

class PositionAdapter() :
    RecyclerView.Adapter<PositionAdapter.PositionsViewHolder>() {

    private var positions = ArrayList<Position>()

    fun setPositions(positions: ArrayList<Position>) {
        this.positions = positions
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionsViewHolder {
        return PositionsViewHolder(
            PositionViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return positions.size
    }

    private var onItemClickListener: ((Position) -> Unit)? = null

    fun setOnItemClickListener(listener: (Position) -> Unit) {
        onItemClickListener = listener
    }

    override fun onBindViewHolder(holder: PositionsViewHolder, position: Int) {


        var image = holder.itemView.findViewById<ImageView>(R.id.ivPositionImage)
        Glide.with(holder.itemView).load(positions[position].picture).into(image)

        holder.binding.tvName.text = positions[position].name
        holder.binding.tvSalaryRange.text = positions[position].salaryRange.toString()

        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(positions[position])
            }
        }

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class PositionsViewHolder(val binding: PositionViewBinding) :
        RecyclerView.ViewHolder(binding.root)
}