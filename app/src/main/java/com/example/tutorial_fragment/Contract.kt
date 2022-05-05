package com.example.tutorial_fragment

import androidx.fragment.app.Fragment

fun Fragment.executor() = requireActivity() as Contract

interface Contract {
    fun getScreenNumber(): Int

    fun createQuote(): String
}