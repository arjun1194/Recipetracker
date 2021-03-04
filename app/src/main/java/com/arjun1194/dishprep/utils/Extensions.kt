package com.arjun1194.dishprep.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(string: String){
    Toast.makeText(this.requireContext(),string,Toast.LENGTH_SHORT).show()
}