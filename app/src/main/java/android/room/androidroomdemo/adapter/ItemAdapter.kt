package android.room.androidroomdemo.adapter

import android.content.Context
import android.room.androidroomdemo.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*


class ItemAdapter(private var context: Context?,
                  private var itemList: List<String>?) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.tvName.text = itemList?.get(position)
    }

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.tv_name
    }
}