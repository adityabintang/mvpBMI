package com.bintang.mvpbmi

import com.bintang.mvpbmi.model.HasilModel

interface HitungView {

    fun onHasil(model: HasilModel)
    fun empty()
}