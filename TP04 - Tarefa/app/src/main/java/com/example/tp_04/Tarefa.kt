package com.example.tp_04

data class Tarefa(
    val nome: String,
    val descricao: String,
    var concluida: Boolean = false
)
