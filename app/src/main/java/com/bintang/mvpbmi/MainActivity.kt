package com.bintang.mvpbmi

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.bintang.mvpbmi.model.HasilModel
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), HitungView {

    private var input1: TextInputEditText? = null
    private var input2: TextInputEditText? = null
    private var btn_hasil: Button? = null
    private var txt_hasil: TextView? = null
    private var hitung_presenter: HitungPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.textInputEditText)
        input2 = findViewById(R.id.TB)
        btn_hasil = findViewById(R.id.button)
        txt_hasil = findViewById(R.id.textView)

        hitung_presenter = HitungPresenter(this)

        btn_hasil?.setOnClickListener {
            hitung_presenter?.hitungBMI(input1?.text.toString(), input2?.text.toString())
        }
        
    }

    override fun onHasil(model: HasilModel) {
        AlertDialog.Builder(this)
                .setTitle("Informasi")
                .setMessage(model.hasilHitung.toString() + model.bmi)
                .setPositiveButton("OK", DialogInterface.OnClickListener{dialoginterface, i ->
                }).show()

    }

    override fun empty() {
        AlertDialog.Builder(this)
                .setTitle("Informasi")
                .setMessage("Tidak Boleh Kosong")
                .setNegativeButton("OK", DialogInterface.OnClickListener{dialoginterface, i ->

                }).show()
    }
}