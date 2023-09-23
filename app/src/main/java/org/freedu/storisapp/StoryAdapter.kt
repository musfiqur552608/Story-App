package org.freedu.storisapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView


class StoryAdapter(private val storyList:List<StoryModel>, private val clickListener:(StoryModel)->Unit):RecyclerView.Adapter<MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val storyItem = layoutInflater.inflate(R.layout.stories_item, parent, false)
        return MyViewHolder(storyItem)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val story = storyList[position]
        holder.bind(story,clickListener)
    }
}
class MyViewHolder(val view:View):RecyclerView.ViewHolder(view) {
    fun bind(story:StoryModel, clickListener: (StoryModel) -> Unit){
        val title = view.findViewById<TextView>(R.id.storyTitle)
        val details = view.findViewById<TextView>(R.id.storyDetails)
        val img = view.findViewById<CircleImageView>(R.id.storyImg)

        title.text = story.title
        details.text = story.details
        img.setImageResource(story.img)

        view.setOnClickListener {
            clickListener(story)
        }
    }

}


