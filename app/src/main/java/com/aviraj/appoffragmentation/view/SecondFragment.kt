package com.aviraj.appoffragmentation.view

import android.os.Bundle
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
import com.aviraj.appoffragmentation.databinding.FragmentSecondBinding
import com.aviraj.appoffragmentation.viewModel.CountViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    // Added Manually
    // Binding CountViewModel
    private  val countViewModel: CountViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        // Added manually
        //
        // Here we update the count value
        binding.decrementButton.setOnClickListener{
            countViewModel.decrement()
        }

        countViewModel.getMutableData().observe(viewLifecycleOwner, Observer { incomingValue ->
            // update the selected filters UI
            // Here we reflect the changes to the app
            binding.textviewSecond.text = "Count : " + incomingValue
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}