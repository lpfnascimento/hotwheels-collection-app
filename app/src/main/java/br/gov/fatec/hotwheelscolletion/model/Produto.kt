package br.gov.fatec.hotwheelscolletion.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Produto(
        val fabricanteMiniatura: String,
        val modeloMiniatura: String,
        val fabricanteCarro: String,
        val codigoMiniatura: String,
        val imagemMiniatura: String? = null


): Parcelable


