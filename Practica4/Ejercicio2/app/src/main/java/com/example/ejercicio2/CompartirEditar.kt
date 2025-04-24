package com.example.ejercicio2


/*

Aqui en esta parte se muestra la nota que se escribio y muestra las opciones
de compartir nota y editar la nota

Autor:      Luis Ampuero
Fecha de creacion:      23/04/25
Ultima fecha de modificación:       23/04/25
*/


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CompartirEditar : AppCompatActivity() {

    private lateinit var textViewNote: TextView
    private lateinit var Compartir: Button
    private lateinit var Editarb: Button
    private var Nota = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compartireditar)

        // Inicializar las vistas
        textViewNote = findViewById(R.id.textViewNote)
        Compartir = findViewById(R.id.Compartir)
        Editarb = findViewById(R.id.Editarb)

        // Recuperar el texto de la nota del intent
        if (savedInstanceState != null) {
            Nota = savedInstanceState.getString("Nota", "")
        } else {
            Nota = intent.getStringExtra("nota") ?: ""
        }

        // Mostrar la nota
        textViewNote.text = Nota

        // Configurar el botón de compartir por correo
        Compartir.setOnClickListener {
            Toast.makeText(this, "Compartido por correo", Toast.LENGTH_SHORT).show()
        }

        // Configurar el botón de editar de nuevo
        Editarb.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("nota_editada", Nota)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    // Guardar el estado de la actividad antes de ser destruida (ej: rotación de pantalla)
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("Nota", Nota)
    }
}