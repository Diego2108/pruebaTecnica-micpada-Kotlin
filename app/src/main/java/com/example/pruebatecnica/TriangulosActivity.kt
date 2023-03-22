package com.example.pruebatecnica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebatecnica.databinding.ActivityTriangulosBinding

private lateinit var binding: ActivityTriangulosBinding
class TriangulosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTriangulosBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setup()

    }

    private fun setup() {
        val base = binding.editTextBase.text
        val altura = binding.editTextAltura.text
        binding.buttonCalcular.setOnClickListener {
            if (base.isNotEmpty() && altura.isNotEmpty()) {
                //aplicarFormula()
                val producto = base.toString().toInt() * altura.toString().toInt()
                val resultado = (producto/2).toString()
                binding.textViewResult.text = resultado
            }
        }

        binding.buttonEliminar.setOnClickListener {
            if (binding.textViewResult.text.isNotEmpty()) {
                base.clear()
                altura.clear()
            }
        }
    }

}