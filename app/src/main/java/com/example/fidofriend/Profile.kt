package com.example.fidofriend

import Beans.User
import Interface.FidoFriendApi
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Profile : AppCompatActivity(){

    private lateinit var service: FidoFriendApi
    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://fidofriend-api.onrender.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(FidoFriendApi::class.java)

        service.getUserById(1).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                user = response.body()!!

                val firstName: TextView = findViewById(R.id.textViewFirstName)
                val lastName: TextView = findViewById(R.id.textViewLastName)
                val email: TextView = findViewById(R.id.textViewEmail)
                val userImg: ImageView = findViewById(R.id.imageViewAvatar)

                firstName.text = "Nombre: " + user.firstName
                lastName.text = "Apellido: " + user.lastName
                email.text = "Email: " + user.email
                Picasso.get().load(user.imgUrl).placeholder(R.drawable.baseline_face_24)
                    .error(R.drawable.baseline_face_24)
                    .into(userImg)
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }


}