package br.gov.fatec.hotwheelscolletion.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.gov.fatec.hotwheelscolletion.R
import br.gov.fatec.hotwheelscolletion.model.Produto
import br.gov.fatec.hotwheelscolletion.dao.ProdutosDao
import br.gov.fatec.hotwheelscolletion.databinding.ActivityFormularioProdutoBinding
import br.gov.fatec.hotwheelscolletion.tentaCarregarImagem
import br.gov.fatec.hotwheelscolletion.ui.dialog.FormularioImagemDialog

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    private val binding by lazy {
        ActivityFormularioProdutoBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Cadastrar produto"
        configuraBotaoSalvar()
        binding.activityFormularioProdutoImagem.setOnClickListener {
            FormularioImagemDialog(this)
                .mostra(url) { imagem ->
                    url = imagem
                    binding.activityFormularioProdutoImagem.tentaCarregarImagem(url)
                }
        }
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioProdutoBotaoSalvar
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = criaProduto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun criaProduto(): Produto {
              val fabMiniatura = binding.activityFormularioProdutoFabricanteMiniatura.text.toString()
              val modMiniatura = binding.activityFormularioProdutoModelo.text.toString()
              val fabCarro = binding.activityFormularioProdutoFabricanteCarro.text.toString()
              val codMiniatura = binding.activityFormularioProdutoCodigo.text.toString()


        return Produto(
            fabricanteMiniatura = fabMiniatura,
            modeloMiniatura = modMiniatura,
            fabricanteCarro = fabCarro,
            codigoMiniatura = codMiniatura,
            imagemMiniatura = url,
        )
    }

}