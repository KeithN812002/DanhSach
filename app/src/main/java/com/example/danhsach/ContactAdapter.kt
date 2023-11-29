package com.example.danhsach

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter(private val contacts: List<Contact>) :
    ArrayAdapter<Contact>(context, R.layout.item_contact, contacts) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contact = getItem(position)

        val itemView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_contact, parent, false)

        itemView.contactName.text = contact?.name

        return itemView
    }
}
