package com.example.deportes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        val items = ArrayList<Tarjeta>()
        items.add(Tarjeta(R.mipmap.ic_baloncesto_foreground, R.string.baloncesto))
        items.add(Tarjeta(R.mipmap.ic_futbol_foreground, R.string.futbol))
        items.add(Tarjeta(R.mipmap.ic_beisbol_foreground, R.string.beisbol))
        items.add(Tarjeta(R.mipmap.ic_ciclismo_foreground, R.string.ciclismo))
        items.add(Tarjeta(R.mipmap.ic_golf_foreground, R.string.golf))
        items.add(Tarjeta(R.mipmap.ic_hipica_foreground, R.string.hipica))
        items.add(Tarjeta(R.mipmap.ic_natacion_foreground, R.string.natacion))
        items.add(Tarjeta(R.mipmap.ic_pinpon_foreground, R.string.pinpon))
        items.add(Tarjeta(R.mipmap.ic_tenis_foreground, R.string.tenis))

        val recView = findViewById<RecyclerView>(R.id.recyclerView)

        recView.setHasFixedSize(true)

        val adaptador = CardsAdapter(items)
        recView.adapter = adaptador
        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        fab.setOnClickListener {
            val list = adaptador.listCheckBox
            var text = "Has seleccionado "
            if (list.size > 0) {
                for (i in 0 until list.size) {
                    text += when {
                        i < list.size - 2 -> "${list[i].text}, "
                        i == list.size - 2 -> "${list[i].text} y "
                        else -> "${list[i].text}."
                    }
                }
            }else{
                text = "No se ha seleccionado ningun deporte."
            }
            Toast.makeText(this, text,Toast.LENGTH_LONG).show()
        }
    }
}