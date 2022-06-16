package com.lamarck.merecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lamarck.merecycler.model.Live
import kotlinx.android.synthetic.main.res_item_live.view.*
import java.util.ArrayList

class LiveAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Live> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LiveViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.res_item_live,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

             when(holder){
                 is LiveViewHolder ->{
                     holder.bind(items[position])
                 }
             }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setDataSet(lives:List<Live>){
        this.items =lives
    }

    class LiveViewHolder constructor(
        itemView:View
    ):RecyclerView.ViewHolder(itemView){

        private val liveTitle= itemView.title
        private val liveAuthor = itemView.author
        private val liveThumbnail = itemView.thumbnail

        fun bind(live:Live){
            liveTitle.text = live.title
            liveAuthor.text = live.author

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(live.thumbnailUrl)
                .into(liveThumbnail)
        }
    }

}