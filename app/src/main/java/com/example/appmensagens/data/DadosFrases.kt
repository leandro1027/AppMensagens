package com.example.appmensagens.data

import com.example.appmensagens.infra.Constants
import kotlinx.coroutines.internal.AtomicDesc
import kotlin.random.Random

data class Frases(val desc: String, val category: Int)

class DadosFrases {
    private val sol = Constants.FILTER.SOL
    private val nuvem = Constants.FILTER.NUVEM
    private val solnuvem = Constants.FILTER.SOLNUVEM

    val listaDeFrases = listOf(
        Frases(
            "1 Se você estiver comigo não me importo se estivermos na chuva, no sol muito quente, granizo ou neve.",
            sol
        ),
        Frases(
            "2 Se você estiver comigo não me importo se estivermos na chuva, no sol muito quente, granizo ou neve.",
            sol
        ),
        Frases(
            "Você diz que ama a chuva, mas você abre seu guarda-chuva quando chove.",
            nuvem
        ),
        Frases(
            "Um dia de chuva é tão belo como um dia de sol. Ambos existem; cada um é como é.",
            solnuvem
        )
    )

    fun getFrase(value: Int): String {
        val filtro = listaDeFrases.filter { it.category == value }
        return filtro[Random.nextInt(filtro.size)].desc
    }
}
