package com.example.projeto_lp_iv_com_br_moura.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import com.example.businesscontrollv3.viewmodel.TransactionsViewModel
import com.example.projeto_lp_iv_com_br_moura.R
import kotlinx.android.synthetic.main.fragment_resume.*

class TransactionsFragment : Fragment() {

    private lateinit var transactionsViewModel: TransactionsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        transactionsViewModel = ViewModelProvider(this).get(TransactionsViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_transactions, container, false)

        transactionsViewModel.text.observe(viewLifecycleOwner) {
            section_label.text = it
        }

        return root
    }


    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }

}