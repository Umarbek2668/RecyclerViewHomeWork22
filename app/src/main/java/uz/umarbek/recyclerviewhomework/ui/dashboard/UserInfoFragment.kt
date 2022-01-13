package uz.umarbek.recyclerviewhomework.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.umarbek.recyclerviewhomework.databinding.FragmentUserInfoBinding
import uz.umarbek.recyclerviewhomework.ui.data.MockData

class UserInfoFragment : Fragment() {

    private var _binding: FragmentUserInfoBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserInfoBinding.inflate(inflater, container, false)
        getInfo()
        return binding.root
    }

    private fun getInfo() {
        val data = arguments?.getSerializable("data") as MockData.SimpleData
        binding.infoName.text = data.name
        binding.infoAge.text = data.age.toString()
        binding.infoUsername.text = data.username
        binding.infoImage.setBackgroundResource(data.image)

    }

}