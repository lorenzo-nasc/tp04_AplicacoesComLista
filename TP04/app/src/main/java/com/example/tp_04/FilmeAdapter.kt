package com.example.tp_04
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmeAdapter(
    private val filmes: MutableList<Filme>
) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titulo: TextView = itemView.findViewById(R.id.txtTitulo)
        val diretor: TextView = itemView.findViewById(R.id.txtDiretor)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FilmeViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)

        return FilmeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: FilmeViewHolder,
        position: Int
    ) {

        val filme = filmes[position]

        holder.titulo.text = filme.titulo
        holder.diretor.text = "Diretor: ${filme.diretor}"
    }

    override fun getItemCount(): Int {
        return filmes.size
    }

    fun adicionarFilme(filme: Filme) {

        filmes.add(filme)

        notifyItemInserted(filmes.size - 1)
    }
}