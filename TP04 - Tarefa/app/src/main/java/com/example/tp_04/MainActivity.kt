package com.example.tp_04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nome = findViewById<EditText>(R.id.edtNome)
        val descricao = findViewById<EditText>(R.id.edtDescricao)
        val adicionar = findViewById<Button>(R.id.btnAdicionar)
        val recycler = findViewById<RecyclerView>(R.id.recyclerTarefas)
        val adapter = TarefaAdapter(mutableListOf())

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        adicionar.setOnClickListener {
            val tarefa = Tarefa(nome.text.toString(), descricao.text.toString())
            adapter.adicionarTarefa(tarefa)
            nome.text.clear()
            descricao.text.clear()
        }
    }
}
