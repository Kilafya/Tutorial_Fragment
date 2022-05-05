package com.example.tutorial_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tutorial_fragment.databinding.FragmentContentBinding

class ContentFragment : Fragment() {

    private lateinit var binding: FragmentContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(inflater, container, false)
        with (binding) {
            tvScreenNumber.text = "Screen № ${getCounterValue()}"
            tvQuote.text = getQuote()
            btnNext.setOnClickListener { launchNext() }
            btnBack.setOnClickListener { requireActivity().onBackPressed() }
        }
        return binding.root
    }

    private fun launchNext() {
        val fragment = newInstance(
            counterValue = executor().getScreenNumber() + 1,
            quote = executor().createQuote()
        )
        parentFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun getCounterValue() = requireArguments().getInt(KEY_COUNTER_VALUE)

    private fun getQuote(): String = requireArguments().getString(KEY_QUOTE) ?: "Quote not found"

    companion object {
        const val KEY_COUNTER_VALUE = "COUNTER_VALUE"
        const val KEY_QUOTE = "QUOTE"

        fun newInstance(counterValue: Int, quote: String): ContentFragment {
            val args = Bundle().apply {
                putInt(KEY_COUNTER_VALUE, counterValue)
                putString(KEY_QUOTE, quote)
            }
            val fragment = ContentFragment()
            fragment.arguments = args
            return fragment
        }
    }
}