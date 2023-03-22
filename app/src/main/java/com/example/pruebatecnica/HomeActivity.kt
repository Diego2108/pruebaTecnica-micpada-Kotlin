package com.example.pruebatecnica

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebatecnica.databinding.ActivityHomeBinding

import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    BASIC,
    GOOGLE
}

private lateinit var binding: ActivityHomeBinding
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        //replaceFragment(HomeFragment())

        // SETUP
        val bundle = intent.extras
        val email = bundle?.getString("email")
        val provider = bundle?.getString("provider")
        setup(email ?: "", provider ?: "")


        //Persistencia de datos
        val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
        prefs.putString("email",email)
        prefs.putString("provider",provider)
        prefs.apply()
    }

    private fun add() {
        TODO("Not yet implemented")
    }

    private fun setup(email:String,provider:String) {
        title = "Inicio"
        binding.textViewUser.text = email

        binding.buttonCerrarSesion.setOnClickListener {

            //borrar preference
            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }

        binding.buttonWebView.setOnClickListener {
            val webViewIntent = Intent(this,WebViewActivity::class.java)
            startActivity(webViewIntent)
        }

        binding.buttonTriangulos.setOnClickListener {
            val triangulosIntent = Intent(this,TriangulosActivity::class.java)
            startActivity(triangulosIntent)
        }

    }
}
