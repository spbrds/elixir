package pt.attcei.ersu.utils

import android.support.v7.app.AppCompatActivity
import pt.attcei.ersu.exceptions.ErseException

class ExceptionUtils {
    companion object {
        fun buildErrorDialog(context: AppCompatActivity, e: ErseException){

        }

        fun buildErrorDialog(context : AppCompatActivity, e:Exception){
            Companion.buildErrorDialog(context, ErseException("000"))
        }
    }

}