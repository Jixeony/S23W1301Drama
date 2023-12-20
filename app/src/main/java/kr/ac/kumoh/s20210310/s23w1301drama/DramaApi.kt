package kr.ac.kumoh.s20210310.s23w1301drama

import retrofit2.http.GET

interface DramaApi {
    @GET("drama")
    suspend fun getDramas(): List<Drama>
}