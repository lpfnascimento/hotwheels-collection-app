package br.gov.fatec.hotwheelscolletion.dao

import br.gov.fatec.hotwheelscolletion.model.Produto


class ProdutosDao {

    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                fabricanteMiniatura = "Hotwheels",
                modeloMiniatura = "Laranja - 1980",
                fabricanteCarro = "Dogde",
                codigoMiniatura = "11111",
                imagemMiniatura = "https://images-americanas.b2w.io/produtos/01/00/img/3970284/4/3970284462_1GG.jpg"
            ),
            Produto(
                fabricanteMiniatura = "Hotwheels",
                modeloMiniatura = "Laranja - 1980",
                fabricanteCarro = "Dogde",
                codigoMiniatura = "11111",
                imagemMiniatura = "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQ-kHchCjHMwBRlbDUrQYxpzfNXoresPeoDjA8SmX05jas51duTRUZjIjXx6zOoLI7QqwYegrtfJA&usqp=CAc"
            ),
            Produto(
                fabricanteMiniatura = "Dogde Charge",
                modeloMiniatura = "Laranja - 1980",
                fabricanteCarro = "Dogde",
                codigoMiniatura = "11111",
                imagemMiniatura = "https://cf.shopee.com.br/file/c7b50f073534449a002d748f21b88994"
            ),

        )
    }

}