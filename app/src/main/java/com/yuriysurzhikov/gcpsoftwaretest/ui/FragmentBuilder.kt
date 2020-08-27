package com.yuriysurzhikov.gcpsoftwaretest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.yuriysurzhikov.gcpsoftwaretest.model.FunctionType
import com.yuriysurzhikov.gcpsoftwaretest.model.ItemMenuEntity
import com.yuriysurzhikov.gcpsoftwaretest.ui.image.ImageFragment
import com.yuriysurzhikov.gcpsoftwaretest.ui.text.TextFragment
import com.yuriysurzhikov.gcpsoftwaretest.ui.url.UrlFragment

class FragmentBuilder constructor() {

    companion object {
        fun create(menuItem: ItemMenuEntity): Fragment {
            val fragment: Fragment = when(menuItem.function) {
                is FunctionType.Url -> {
                    UrlFragment()
                }
                is FunctionType.Image -> {
                    ImageFragment()
                }
                is FunctionType.Text -> {
                    TextFragment()
                }
            }
            val bundle = Bundle()
            bundle.putString("param", menuItem.function.param)
            fragment.arguments = bundle
            return fragment
        }
    }
}