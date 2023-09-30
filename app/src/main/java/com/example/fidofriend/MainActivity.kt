package com.example.fidofriend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el Toolbar como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.nav_profile -> startActivity(Intent(this, Profile::class.java))
            R.id.nav_home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
            R.id.nav_appointments -> Toast.makeText(this, "Appointments", Toast.LENGTH_SHORT).show()
            R.id.nav_service -> Toast.makeText(this, "Services", Toast.LENGTH_SHORT).show()
            R.id.nav_products -> Toast.makeText(this, "Products", Toast.LENGTH_SHORT).show()
            R.id.nav_logout -> startActivity(Intent(this, Login::class.java))
        }

        return super.onOptionsItemSelected(item)
    }

}