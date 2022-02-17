package com.example.whatweather.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.whatweather.R
import kotlinx.android.synthetic.main.second_fragment.*

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.second_fragment, container, false)
    }

    override fun onStart() {
        super.onStart()

        viewModel.getLiveString().observe(viewLifecycleOwner) { t ->
            val text = tvMessageFromMainFragment.text.toString() + t
            tvMessageFromMainFragment.text = text
        }
    }

}