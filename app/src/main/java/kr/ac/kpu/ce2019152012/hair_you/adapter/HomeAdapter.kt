package kr.ac.kpu.ce2019152012.hair_you.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.dto.HomeShopDataVo

class HomeAdapter:
    RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

        var datas = mutableListOf<HomeShopDataVo>()

    interface OnItemClickListener {
        fun onItemClick(v: View, data: HomeShopDataVo, post:Int)
    }

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_shop,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val ShopName = itemView.findViewById<TextView>(R.id.shop_name)
        private val ShopPlace = itemView.findViewById<TextView>(R.id.shop_place)

        fun bind(item: HomeShopDataVo){

            ShopName.text = item.shopname
            ShopPlace.text = item.shop_road_name

            val pos = adapterPosition
            if ( pos != RecyclerView.NO_POSITION){
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView, item, pos)
                }
            }
        }
    }
}