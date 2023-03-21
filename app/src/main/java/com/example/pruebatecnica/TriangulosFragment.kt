package com.example.pruebatecnica

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pruebatecnica.databinding.FragmentTriangulosBinding

private lateinit var binding: FragmentTriangulosBinding
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private val base = binding.editTextBase.text
private val altura = binding.editTextAltura.text

class TriangulosFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_triangulos, container, false)
        setup()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PruebaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TriangulosFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setup() {
        binding.buttonCalcular.setOnClickListener {
            if (base.isNotEmpty() && altura.isNotEmpty()) {
                //aplicarFormula()
                val producto = base.toString().toInt() * altura.toString().toInt()
                val resultado = (producto/2).toString()
                binding.textViewResult.text = resultado
            }
        }
    }
}