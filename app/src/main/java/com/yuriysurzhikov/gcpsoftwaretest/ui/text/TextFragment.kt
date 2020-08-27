package com.yuriysurzhikov.gcpsoftwaretest.ui.text

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.lifecycle.ViewModelInject
import com.bumptech.glide.Glide
import com.yuriysurzhikov.gcpsoftwaretest.R
import kotlinx.android.synthetic.main.fragment_image.*
import kotlinx.android.synthetic.main.fragment_text.*

class TextFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("param")?.let { bindParam(it) }
    }

    private fun bindParam(param: String) {
        text_home.text = param
    }
}