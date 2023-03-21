package com.example.pruebatecnica

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pruebatecnica.databinding.FragmentHomeBinding

const val EMAIL = "email"
const val PROVIDER = "provider"

private lateinit var binding: FragmentHomeBinding

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var email: String? = null
    private var provider: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            email = it.getString(EMAIL)
            provider = it.getString(PROVIDER)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
        binding.textViewUser.text = email
    }

    companion object {
        @JvmStatic
        fun newInstance(email: String, provider: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(EMAIL, email)
                    putString(PROVIDER, provider)
                }
            }
    }
}