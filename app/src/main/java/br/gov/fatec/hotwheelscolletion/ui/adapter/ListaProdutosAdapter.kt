package br.gov.fatec.hotwheelscolletion.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.gov.fatec.hotwheelscolletion.model.Produto
import br.gov.fatec.hotwheelscolletion.databinding.ProdutoItemBinding
import br.gov.fatec.hotwheelscolletion.tentaCarregarImagem

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>,
    var quandoClicaNoItem: (produto: Produto) -> Unit = {}
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    inner class ViewHolder(private val binding: ProdutoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var produto: Produto

        init {
            itemView.setOnClickListener {
                if (::produto.isInitialized) {
                    quandoClicaNoItem(produto)
                }
            }
        }

        fun vincula(produto: Produto) {
            this.produto = produto
            val fabricanteMiniatura = binding.produtoItemFabricanteMiniatura
            fabricanteMiniatura.text = produto.fabricanteMiniatura
            val modeloMiniatura = binding.produtoItemModeloMiniatura
            modeloMiniatura.text = produto.modeloMiniatura
            val fabricanteCarro= binding.produtoItemFabricanteCarro
            fabricanteCarro.text = produto.fabricanteCarro


            val visibilidade = if (produto.imagemMiniatura != null) {
                View.VISIBLE
            } else {
                View.GONE
            }

            binding.imageView.visibility = visibilidade

            binding.imageView.tentaCarregarImagem(produto.imagemMiniatura)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
