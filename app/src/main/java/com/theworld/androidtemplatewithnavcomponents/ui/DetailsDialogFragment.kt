package com.theworld.androidtemplatewithnavcomponents.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.theworld.androidtemplatewithnavcomponents.R
import com.theworld.androidtemplatewithnavcomponents.data.response.PostOffice
import com.theworld.androidtemplatewithnavcomponents.databinding.DialogDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class DetailsDialogFragment : BottomSheetDialogFragment() {

    companion object {
        private const val TAG = "DetailsDialogFragment"
    }

    private var _binding: DialogDetailsBinding? = null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsDialogFragmentArgs>()


    /*----------------------------------------- On Create View -------------------------------*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DialogDetailsBinding.inflate(inflater)
        return binding.root
    }

    /*----------------------------------------- On ViewCreated -------------------------------*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI(args.postOffice)
    }


    private fun updateUI(data: PostOffice) {

        binding.tvName.text = data.name
        binding.tvPin.text = data.pINCode
        binding.tvTaluka.text = data.taluk
        binding.tvState.text = data.state

    }


    /*----------------------------------------- On DestroyView -------------------------------*/

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}