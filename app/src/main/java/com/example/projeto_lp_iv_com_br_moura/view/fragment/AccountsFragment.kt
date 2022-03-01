package com.example.projeto_lp_iv_com_br_moura.view.fragment



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.projeto_lp_iv_com_br_moura.R
import com.example.projeto_lp_iv_com_br_moura.viewmodel.AccountsViewModel

import kotlinx.android.synthetic.main.fragment_resume.*

class AccountsFragment : Fragment() {

    lateinit var accountsViewModel: AccountsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        accountsViewModel = ViewModelProvider(this).get(AccountsViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_accounts, container, false)

        accountsViewModel.text.observe(viewLifecycleOwner) {
            section_label.text = it
        }

        return root
    }

    companion object {
        const val ARG_SECTION_NUMBER = "section_number"
    }
}