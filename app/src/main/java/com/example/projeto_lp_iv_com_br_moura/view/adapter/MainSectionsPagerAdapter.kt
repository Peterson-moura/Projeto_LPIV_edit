package com.example.projeto_lp_iv_com_br_moura.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.projeto_lp_iv_com_br_moura.view.fragment.AccountsFragment
import com.example.projeto_lp_iv_com_br_moura.view.fragment.ResumeFragment
import com.example.projeto_lp_iv_com_br_moura.view.fragment.TransactionsFragment

class MainSectionsPagerAdapter(private val lifecycle: Lifecycle, fm: FragmentManager) :
        FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 3
    }
    // arr = [null, null, null]
    /*
    *
    * for (int position = 0; position < getItemCount(); position++) {
    *   arr[position] = createFragment(position)
    * }
    *  arr = [Resume, Transactions, Accounts]
    * */
    // arr[0] = createFragment(0)
    // arr[1] = createFragment(1)
    // arr[2] = createFragment(2)
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> createFragmentWithSectionNumber(ResumeFragment(), position)
            1 -> createFragmentWithSectionNumber(TransactionsFragment(), position)
            2 -> createFragmentWithSectionNumber(AccountsFragment(), position)
            else -> throw IllegalAccessException("Posicao desconhecida")
        }
    }

    private fun createFragmentWithSectionNumber(fragment: Fragment, position: Int): Fragment {
        return fragment.apply {
            arguments = Bundle().apply {
                putInt(ResumeFragment.ARG_SECTION_NUMBER, position)
            }
        }
    }

}