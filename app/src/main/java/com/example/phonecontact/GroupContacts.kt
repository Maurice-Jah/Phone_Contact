package com.example.phonecontact

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.phonecontact.adapters.Contact
import com.example.phonecontact.adapters.ContactAdapter
import com.example.phonecontact.databinding.ActivityGroupContactsBinding
import com.google.android.material.button.MaterialButton

class GroupContacts : AppCompatActivity() {
    private lateinit var binding: ActivityGroupContactsBinding

    private var adapter = ContactAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGroupContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpData(binding)


    }


    private fun setUpData(binding:ActivityGroupContactsBinding){
        binding.contactRv.adapter = adapter
        binding.contactRv.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialog,null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.nameEt)
        val number = view.findViewById<TextView>(R.id.numberET)
        val saveBtn = view.findViewById<MaterialButton>(R.id.saveBt)

        number.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })


        val alertDialog = builder.create()

            saveBtn.setOnClickListener{
            val contact = Contact(name.text.toString(), number.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setUpContacts(contacts)
            alertDialog.dismiss()
        }


        binding.fab.setOnClickListener{
            alertDialog.show()
        }

    }
}



