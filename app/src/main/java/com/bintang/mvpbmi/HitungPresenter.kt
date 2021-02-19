package com.bintang.mvpbmi

import com.bintang.mvpbmi.model.HasilModel
import kotlin.math.roundToInt

class HitungPresenter(var view: HitungView,) {

    fun hitungBMI(inp1: String, inp2:String) = if (inp1.isNotEmpty() && inp2.isNotEmpty()) {
        val inputan1 = inp1.toDouble()
        val inputan2 = inp2.toDouble()


        val bmi = ((inputan2*inputan2).toInt()/inputan1.toInt())
        var hasil = ""


        when (bmi) {
            in 20..40 -> {
                hasil = "Kurus"
            }
            in 50..80 -> {
               hasil =  "Normal"
            }
            in 90..200 -> {
               hasil = "Berat"
            }
            else -> {
              hasil =  "Tidak Terdefinisi"
            }
        }

        var model = HasilModel(bmi.toDouble(), "" + hasil)
        view.onHasil(model)
    }
    else {
        view.empty()
    }

}