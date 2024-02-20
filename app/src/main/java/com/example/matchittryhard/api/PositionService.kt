package com.example.matchittryhard.api

import com.example.matchittryhard.model.Position
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer

interface PositionService{

    suspend fun getPositions(): List<Position>

    companion object {

        fun create(): PositionService {
            return PositionServiceImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}