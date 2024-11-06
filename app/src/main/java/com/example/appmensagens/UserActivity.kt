package com.example.appmensagens

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appmensagens.R
import com.example.appmensagens.databinding.ActivityUserBinding
import com.example.appmensagens.infra.Constants
import com.example.appmensagens.infra.Security

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.botaosalvar.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.botaosalvar) {
            validarNome()
        }
    }

    private fun validarNome() {
        val nome = binding.editNome.text.toString()
        if (nome != "") {
            Security(this).searchString(Constants.KEY.USER_NAME, nome)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, R.string.validar_nome, Toast.LENGTH_SHORT).show()
        }
    }
}
