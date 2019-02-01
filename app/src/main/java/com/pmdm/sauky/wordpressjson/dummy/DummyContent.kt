package com.pmdm.sauky.wordpressjson.dummy

import android.util.Log
import org.jetbrains.anko.doAsync
import org.json.JSONArray
import java.net.URL
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    val ITEMS: MutableList<DummyItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    val LOGTAG = "SEGUIMIENTO"

    init {
        // Add some sample items.
        doAsync{
            // capturamos los errores de la peticion
            try {
                // peticion a un servidor rest que devuelve un json generico
                val respuesta = URL("https://jsonplaceholder.typicode.com/posts").readText()
                // parsing data
                // sabemos que recibimos un array de objetos JSON
                val miJSONArray = JSONArray(respuesta)
                // recorremos el Array
                for (jsonIndex in 0..(miJSONArray.length() - 1)) {
                    // asignamos el valor de 'title' en el constructor de la data class 'DummyItem'
                    val idpost = miJSONArray.getJSONObject(jsonIndex).getString("id")
                    val titulo = miJSONArray.getJSONObject(jsonIndex).getString("title")
                    val resumen = miJSONArray.getJSONObject(jsonIndex).getString("body")
                    addItem(DummyItem(idpost,titulo,resumen))
                }
                Log.d(LOGTAG,"Peticion terminada")
            } catch (e: Exception) { // Si algo va mal lo capturamos
                Log.d(LOGTAG,"Algo va mal: $e")
            }
    }
    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }


    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val title: String, val resumen: String) {
        override fun toString(): String = title
    }
}
