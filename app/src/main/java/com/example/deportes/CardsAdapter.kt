package com.example.deportes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class CardsAdapter(var items: ArrayList<Tarjeta>) : RecyclerView.Adapter<CardsAdapter.TarjViewHolder>() {
    val listCheckBox = arrayListOf<CheckBox>()

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
        private var image: ImageView = itemView.findViewById(R.id.imageView)

        fun bindTarjeta(t: Tarjeta) = with(itemView) {
            checkBox.setText(t.cadena)
            image.setImageResource(t.image)
        }

        fun getChechBox(): CheckBox{
            return checkBox
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        val item = items[pos]
        viewHolder.bindTarjeta(item)
        viewHolder.getChechBox().setOnCheckedChangeListener { _, _ ->
            if (viewHolder.getChechBox().isChecked)
                listCheckBox.add(viewHolder.getChechBox())
            else
                listCheckBox.remove(viewHolder.getChechBox())
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}