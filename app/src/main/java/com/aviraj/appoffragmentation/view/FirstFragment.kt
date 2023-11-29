package com.aviraj.appoffragmentation.view

import  android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.aviraj.appoffragmentation.R
import com.aviraj.appoffragmentation.viewModel.CountViewModel
import com.aviraj.appoffragmentation.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Added manually
    // Binding CountViewModel
    private val countViewModel: CountViewModel by activityViewModels()
   // private val countViewModel: CountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Initialization
        // connect xml of fragment with Java/Kotlin code
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    // after Fragments/View is created you add logic
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        // Added Manualy
        // Performing increment operation in first fragment
        // Here we update the count value
        binding.incrementButton.setOnClickListener {
            countViewModel.increment()
        }

        countViewModel.getMutableData().observe(viewLifecycleOwner, Observer { incomingValue ->
            // update the selected filters UI
            // Here we reflect the changes to the app
            binding.textviewFirst.text = "Count : " + incomingValue
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}