package com.example.tp_04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerFilmes: RecyclerView
    private lateinit var adapter: FilmeAdapter

    private var usandoGrid = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtDiretor = findViewById<EditText>(R.id.edtDiretor)

        val btnAdicionar = findViewById<Button>(
            R.id.btnAdicionar
        )

        val btnLayout = findViewById<Button>(
            R.id.btnLayout
        )

        recyclerFilmes = findViewById(
            R.id.recyclerFilmes
        )

        val filmes = mutableListOf(

            Filme(
                "Interestelar",
                "Christopher Nolan"
            ),

            Filme(
                "Matrix",
                "Lana e Lilly Wachowski"
            ),

            Filme(
                "O Poderoso Chefão",
                "Francis Ford Coppola"
            )
        )

        adapter = FilmeAdapter(filmes)

        recyclerFilmes.adapter = adapter

        recyclerFilmes.layoutManager =
            LinearLayoutManager(this)

        btnAdicionar.setOnClickListener {

            val titulo = edtTitulo.text.toString().trim()

            val diretor = edtDiretor.text.toString().trim()

            if (titulo.isEmpty() || diretor.isEmpty()) {

                Toast.makeText(
                    this,
                    "Preencha título e diretor",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            val filme = Filme(
                titulo,
                diretor
            )

            adapter.adicionarFilme(filme)

            edtTitulo.text.clear()
            edtDiretor.text.clear()
        }

        btnLayout.setOnClickListener {

            if (usandoGrid) {

                recyclerFilmes.layoutManager =
                    LinearLayoutManager(this)

                btnLayout.text = "Usar Grid"

                usandoGrid = false

            } else {

                recyclerFilmes.layoutManager =
                    GridLayoutManager(this, 2)

                btnLayout.text = "Usar Lista"

                usandoGrid = true
            }
        }
    }
}