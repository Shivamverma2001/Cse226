package com.example.sv_cse226

class ContactDataModelClass (val title: String, val desc: String, val image: Int, var checked: Boolean) {
    fun isChecked(): Boolean{
        return checked
    }
}