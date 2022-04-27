package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.login.databinding.FragmentMainBinding

class mainFragment : Fragment(R.layout.fragment_main){
    // using kotlin backing property to remove headache of adding null safety to everywhere in binding object , use _binding for nullable and binding for non_nullable
    // ue nullable binding object only between onCreateView and onDestroyView
    private var _binding:FragmentMainBinding? = null
    private val binding get() = _binding!!

//    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle? ): View? {
//        //usage of view binding in fragment
//        _binding = FragmentMainBinding.inflate(inflater,container,false) // used when view is not inflated yet
//
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view) // used when view is already inflated
        binding.txtFragment.text = "hello from inside fragment"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // have to make it null so that when view is destroy but fragment still exists before onDestroy, binding is also null
    }
}