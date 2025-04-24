package com.example.ejercicio2


/*
Aqui se muestran la parte donde se va a poner escribir la nota y el boton de
continuar

Autor:      Luis Ampuero
Fecha de creacion:      23/04/25
Ultima fecha de modificación:       23/04/25
*/




import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class Notae : AppCompatActivity() {


    private lateinit var editarNota: EditText
    private lateinit var Compartir: Button
    private var Nota = ""



    private val Resultado = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val notarecibida = result.data?.getStringExtra("nota_editada") ?: ""
            editarNota.setText(notarecibida)
            editarNota.setSelection(notarecibida.length)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notae)
        editarNota = findViewById(R.id.editarNota)
        Compartir = findViewById(R.id.Compartir)

        
        if (savedInstanceState != null) {
            Nota = savedInstanceState.getString("Nota", "")
            editarNota.setText(Nota)
        }
        Compartir.setOnClickListener {
            Nota = editarNota.text.toString()

            val intent = Intent(this, CompartirEditar::class.java)
            intent.putExtra("nota", Nota)
            Resultado.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Nota", editarNota.text.toString())
    }
}