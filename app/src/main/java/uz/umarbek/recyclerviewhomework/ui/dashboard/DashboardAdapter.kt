package uz.umarbek.recyclerviewhomework.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import uz.umarbek.recyclerviewhomework.databinding.ItemDashboardBinding
import uz.umarbek.recyclerviewhomework.ui.data.MockData

class DashboardAdapter() : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    val list: ArrayList<MockData.SimpleData> = MockData.getSimpleData()
    var onItemClick: ((MockData.SimpleData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemDashboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(var binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(list[adapterPosition])
            }
        }

        fun bindData(data: MockData.SimpleData) {
            val binding = binding as ItemDashboardBinding
            binding.itemName.text = data.name
            binding.itemAge.text = data.age.toString()
            binding.idImage.setBackgroundResource(data.image)
            binding.itemUserName.text = data.username
        }
    }
}