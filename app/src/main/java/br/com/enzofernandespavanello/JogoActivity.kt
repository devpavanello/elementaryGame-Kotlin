package br.com.enzofernandespavanello

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jogo)

        val textViewNomeJogador = findViewById<TextView>(R.id.textViewNomeJogador)
        val textViewSexoJogador = findViewById<TextView>(R.id.textViewSexoJogador)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)
        val textViewEscolhas = findViewById<TextView>(R.id.textViewEscolhas)

        val buttonAgua = findViewById<Button>(R.id.buttonAgua)
        val buttonFogo = findViewById<Button>(R.id.buttonFogo)
        val buttonPlanta = findViewById<Button>(R.id.buttonPlanta)

        // Recebe os dados da tela anterior
        val nomeJogador = intent.getStringExtra("NOME_JOGADOR")
        val sexoJogador = intent.getStringExtra("SEXO_JOGADOR")

        textViewNomeJogador.text = nomeJogador
        textViewSexoJogador.text = sexoJogador

        // Função para calcular o resultado da jogada
        fun calcularJogada(escolhaJogador: String) {
            val opcoes = listOf("Água", "Fogo", "Planta")
            val escolhaAdversario = opcoes.random()

            val resultado = when {
                escolhaJogador == escolhaAdversario -> "Empate"
                escolhaJogador == "Água" && escolhaAdversario == "Fogo" -> "Você venceu!"
                escolhaJogador == "Fogo" && escolhaAdversario == "Planta" -> "Você venceu!"
                escolhaJogador == "Planta" && escolhaAdversario == "Água" -> "Você venceu!"
                else -> "Você perdeu!"
            }

            textViewResultado.text = resultado
            textViewEscolhas.text = "$escolhaJogador vs $escolhaAdversario"
        }

        // Configura os botões para realizar a jogada
        buttonAgua.setOnClickListener {
            calcularJogada("Água")
        }

        buttonFogo.setOnClickListener {
            calcularJogada("Fogo")
        }

        buttonPlanta.setOnClickListener {
            calcularJogada("Planta")
        }
    }
}
