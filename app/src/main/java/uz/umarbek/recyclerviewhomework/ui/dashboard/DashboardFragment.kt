package uz.umarbek.recyclerviewhomework.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.umarbek.recyclerviewhomework.R
import uz.umarbek.recyclerviewhomework.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null
    private lateinit var adapter: DashboardAdapter
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        setUpRecyclerView()
        recyclerClick()
        return binding.root
    }

    private fun setUpAdapter() {
        adapter = DashboardAdapter()
    }

    private fun recyclerClick() {
        adapter.onItemClick = {
            val bundle = Bundle()
            bundle.putSerializable("data", it)
            findNavController().navigate(R.id.userInfoFragment, bundle)
        }
    }

    private fun setUpRecyclerView() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}