package Interface

import Beans.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FidoFriendApi {
    @GET("/api/User/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>
}