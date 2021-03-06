package kr.ac.kpu.ce2019152012.hair_you.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kr.ac.kpu.ce2019152012.hair_you.R
import kr.ac.kpu.ce2019152012.hair_you.dto.SearchDataVo

class SearchAdapter(var searchs: ArrayList<SearchDataVo>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>(), Filterable {

    var searchList = ArrayList<SearchDataVo>()

    var itemFilter = ItemFilter()

    init {
        searchList.addAll(searchs)
    }

    interface OnItemClickListener {
        fun onItemClick(v: View, data: SearchDataVo, post: Int)
    }

    private var listener: OnItemClickListener? = null
    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_shop, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = searchList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(searchList[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val ShopName = itemView.findViewById<TextView>(R.id.shop_name)
        private val ShopPlace = itemView.findViewById<TextView>(R.id.shop_place)
        private val ShopRoadPlace = itemView.findViewById<TextView>(R.id.shop_roadplace)

        fun bind(item: SearchDataVo) {
            ShopName.text = item.ShopName
            ShopPlace.text = item.ShopAdd1
            ShopRoadPlace.text = item.ShopAdd2

            val pos =adapterPosition
            if ( pos != RecyclerView.NO_POSITION){
                itemView.setOnClickListener {
                    listener?.onItemClick(itemView,item,pos)
                }
            }
        }
    }

    // -- filter
    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter : Filter() {
        override fun performFiltering(charSequence: CharSequence?): FilterResults {

            val filterString = charSequence.toString()
            val results = FilterResults()

            //????????? ???????????? ????????? ?????? ?????? ????????? ??????
            val filteredList: ArrayList<SearchDataVo> = ArrayList<SearchDataVo>()
            //???????????? ????????? ?????? ?????? ?????? -> ?????? ??????
            if (filterString.trim { it <= ' ' }.isEmpty()) {
                results.values = searchs
                results.count = searchs.size

                return results
                // ???????????? 2?????? ????????? ?????? -> ??????????????? ??????
            } else if (filterString.trim { it <= ' ' }.length <= 2) {
                for (data in searchs){
                    if (data.ShopName.contains(filterString)){
                        filteredList.add(data)
                    }
                }
                // ??? ?????? ??????(?????? ?????? 2?????? ??????) -> ??????/ ??????????????? ??????
            } else {
                for( data in searchs){
                    if ( data.ShopName.contains(filterString) || data.ShopAdd1.contains(filterString)|| data.ShopAdd2.contains(filterString)) {
                        filteredList.add(data)
                    }
                }
            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }
        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults?) {
            searchList.clear()
            searchList.addAll(filterResults?.values as ArrayList<SearchDataVo>)
            notifyDataSetChanged()
        }
    }
}