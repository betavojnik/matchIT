package com.example.matchittryhard.api

import com.example.matchittryhard.model.Position
import com.example.matchittryhard.utility.Constants
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.features.get
import io.ktor.client.request.get
import io.ktor.client.request.url

class PositionServiceImpl (
    private val client: HttpClient
) : PositionService {

    override suspend fun getPositions(): List<Position> {
        return try {
            client.get {
                url(Constants.BASE_URL)
            }
        } catch(e: RedirectResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }

}