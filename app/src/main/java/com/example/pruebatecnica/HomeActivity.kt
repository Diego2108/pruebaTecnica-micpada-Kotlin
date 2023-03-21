package com.example.pruebatecnica

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import com.example.pruebatecnica.databinding.ActivityAuthBinding
import com.example.pruebatecnica.databinding.ActivityHomeBinding
import com.example.pruebatecnica.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType {
    BASIC,
    GOOGLE
}
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

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

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {

                R.id.home -> replaceFragment(HomeFragment())
                R.id.math -> replaceFragment(TriangulosFragment())
                R.id.red -> replaceFragment(MicpadaFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun add() {
        TODO("Not yet implemented")
    }

    private fun setup(email:String,provider:String) {
        title = "Inicio"
        /*binding.textViewUser.text = email

        binding.buttonCerrarSesion.setOnClickListener {

            //borrar preference
            val prefs = getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }*/

    }

    private fun replaceFragment(fragment: Fragment) {
        val framentManager = supportFragmentManager
        val fragmentTransaction = framentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}
