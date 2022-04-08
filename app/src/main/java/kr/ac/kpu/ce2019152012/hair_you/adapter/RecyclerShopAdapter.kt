package kr.ac.kpu.ce2019152012.hair_you.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.user.fragment.HomeFragment
import kr.ac.kpu.ce2019152012.hair_you.user.model.ShopModel

 class RecyclerShopAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerShopAdapter.ViewHolder>() {

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    var datas = mutableListOf<ShopModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler_shop,parent,false)
        return ViewHolder(view)



    }






    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var view: View = view
        private val txtName: TextView = itemView.findViewById(R.id.tv_rv_name)
        private val txtAge: TextView = itemView.findViewById(R.id.tv_rv_age)

        fun bind(item: ShopModel) {
            txtName.text = item.shopname
            txtAge.text = item.location


        }
    }




}

