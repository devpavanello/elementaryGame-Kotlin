package br.com.enzofernandespavanello

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNome = findViewById<EditText>(R.id.editTextNome)
        val radioGroupSexo = findViewById<RadioGroup>(R.id.radioGroupSexo)
        val spinnerPais = findViewById<Spinner>(R.id.spinnerPais)
        val checkBoxTermos = findViewById<CheckBox>(R.id.checkBoxTermos)
        val buttonJogar = findViewById<Button>(R.id.buttonJogar)


        ArrayAdapter.createFromResource(
            this,
            R.array.paises_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPais.adapter = adapter
        }

        buttonJogar.setOnClickListener {
            val nome = editTextNome.text.toString()
            val sexo = when (radioGroupSexo.checkedRadioButtonId) {
                R.id.radioMasculino -> "Masculino"
                R.id.radioFeminino -> "Feminino"
                else -> ""
            }
            val pais = spinnerPais.selectedItem.toString()
            val termosAceitos = checkBoxTermos.isChecked

            if (nome.isNotEmpty() && sexo.isNotEmpty() && termosAceitos) {
                val intent = Intent(this, JogoActivity::class.java).apply {
                    putExtra("NOME_JOGADOR", nome)
                    putExtra("SEXO_JOGADOR", sexo)
                    putExtra("PAIS_JOGADOR", pais)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, preencha todos os campos e aceite os termos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}