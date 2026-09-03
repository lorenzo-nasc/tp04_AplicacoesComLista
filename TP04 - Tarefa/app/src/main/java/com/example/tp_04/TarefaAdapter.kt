package com.example.tp_04

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TarefaAdapter(private val tarefas: MutableList<Tarefa>) : RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>() {
    class TarefaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome: TextView = itemView.findViewById(R.id.txtNome)
        val descricao: TextView = itemView.findViewById(R.id.txtDescricao)
        val botao: Button = itemView.findViewById(R.id.btnConcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return TarefaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.nome.text = tarefa.nome
        holder.descricao.text = tarefa.descricao
        holder.botao.text = if (tarefa.concluida) "Concluida" else "Concluir"
        holder.botao.isEnabled = tarefa.concluida == false
        holder.botao.setOnClickListener {
            tarefa.concluida = true
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int = tarefas.size

    fun adicionarTarefa(tarefa: Tarefa) {
        tarefas.add(tarefa)
        notifyItemInserted(tarefas.size - 1)
    }
}
