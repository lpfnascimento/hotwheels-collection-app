package br.gov.fatec.hotwheelscolletion.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.gov.fatec.hotwheelscolletion.CHAVE_PRODUTO
import br.gov.fatec.hotwheelscolletion.model.Produto
import br.gov.fatec.hotwheelscolletion.R
import br.gov.fatec.hotwheelscolletion.databinding.ActivityDetalhesProdutoBinding
import br.gov.fatec.hotwheelscolletion.tentaCarregarImagem

class DetalhesProdutoActivity : AppCompatActivity(R.layout.activity_detalhes_produto) {

    private val binding by lazy {
        ActivityDetalhesProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        tentaCarregarProduto()
    }

    private fun tentaCarregarProduto() {
        intent.getParcelableExtra<Produto>(CHAVE_PRODUTO)?.let { produtoCarregado ->
            preencheCampos(produtoCarregado)
        } ?: finish()
    }

    private fun preencheCampos(produtoCarregado: Produto) {
        with(binding) {
            activityDetalhesProdutoImagem.tentaCarregarImagem(produtoCarregado.imagemMiniatura)
            activityDetalhesProdutoFabricanteMiniatura.text = produtoCarregado.fabricanteMiniatura
            activityDetalhesProdutoModeloMiniatura.text = produtoCarregado.modeloMiniatura
            activityDetalhesProdutoFabricanteCarro.text = produtoCarregado.fabricanteCarro
            activityDetalhesProdutoCodigo.text = produtoCarregado.codigoMiniatura.toString()
        }
    }

}