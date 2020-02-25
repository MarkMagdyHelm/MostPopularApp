import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mostpopularapp.R
import com.example.mostpopularapp.ui.mplist.adapter.listener.ItemsListener
import kotlinx.android.synthetic.main.recycler_item.view.*
import com.example.mostpopularapp.ui.mplist.models.Result
import com.squareup.picasso.Picasso


class AppsAdapter(var items : ArrayList<Result>, val listener: ItemsListener) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from((parent.context)).inflate(
                R.layout.recycler_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items.get(position)
        holder.tvTyps?.text = item.adxKeywords
        when {
            (item.media!!.size > 0 && item.media!!.get(0).mediaMetadata!!.size > 0) ->
                Picasso.get().load(item.media!!.get(0).mediaMetadata!!.get(0).url).into(
                    holder.pic
                )
        }

        holder.cardview.setOnClickListener { listener.itemChoosen(position) }

    }

    fun UpdateList(list: ArrayList<Result>) {
        this.items = list
        notifyDataSetChanged()
    }

}
   class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val tvTyps = view.title_text
        val cardview = view.cardview
        val pic = view.thumb_imgg



}