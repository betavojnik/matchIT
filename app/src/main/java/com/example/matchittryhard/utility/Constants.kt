package com.example.matchittryhard.utility

import com.example.matchittryhard.model.Position

object Constants {

    const val BASE_URL = "https://22855791cc1e4d67852620597f9c5026.api.mockbin.io/"


    val positions : ArrayList<Position> = arrayListOf(
        Position("VegaIt", about = "you have to do all the things for all the customers", picture = "", salaryRange = 2500.0, description = "tralalalalala", technologies = "Spring, java, kotlin, android studio"),
        Position("Levi9", about = "you have to do all the things for all the customers", picture = "https://msp100.rs/wp-content/uploads/2022/05/vega-logo.jpg", salaryRange = 2500.0, description = "nananana", technologies = "Spring, java, kotlin, android studio"),
        Position("MatchIt", about = "you have to do all the things for all the customers", picture = "https://msp100.rs/wp-content/uploads/2022/05/vega-logo.jpg", salaryRange = 2500.0, description = "hahahahahha", technologies = "Spring, java, kotlin, android studio"),
        Position("Endava", about = "you have to do all the things for all the customers", picture = "https://msp100.rs/wp-content/uploads/2022/05/vega-logo.jpg", salaryRange = 2500.0, description = "lolcina", technologies = "Spring, java, kotlin, android studio"),

        )

    fun getAllPositions(): ArrayList<Position> {
        return positions
    }

}