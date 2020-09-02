package cl.talentodigital.aves.utils.extension

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.alert (message : String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}