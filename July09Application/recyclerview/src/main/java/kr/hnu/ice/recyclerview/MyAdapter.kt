package kr.hnu.ice.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kr.hnu.ice.recyclerview.databinding.ItemMainBinding

class MyAdapter(private val datas: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.itemData.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = datas[position]
        holder.bind(data)
        holder.binding.itemRoot.setOnClickListener {
            Toast.makeText(holder.binding.root.context, "$data 가 클릭되었습니다.", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}