package com.pmdm.sauky.wordpressjson.dummy

import java.util.ArrayList
import java.util.HashMap

object DummyContent {

    val ITEMS: MutableList<DummyItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    val LOGTAG = "SEGUIMIENTO"

    init {
    }

    fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }

}

data class DummyItem(val id: String, val title: String, val resumen: String) {
    // personalizamos toString para que nos devuelva el titulo
    override fun toString(): String = title
}

