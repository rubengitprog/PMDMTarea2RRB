package RoblesBerlanga.Ruben

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnItemClickListener{
    fun onItemClick(position:Int)
}
class Adapter(private val listener: OnItemClickListener):RecyclerView.Adapter<Adapter.ViewHolder>(){



    val names = arrayOf("Mario","Luigi","Peach","Toad")
    val details = arrayOf(
        "El fontanero valiente del Reino Champiñón, conocido por sus saltos.",
        "El hermano de Mario, más tímido pero también un gran aventurero.",
        "La Princesa del Reino Champiñón, siempre en peligro pero valiente.",
        "Un leal sirviente de la Princesa Peach, entusiasta y amistoso."
    )
    val images = intArrayOf(
        R.drawable.mario,  // Cambia esto con el recurso real de la imagen de Mario
        R.drawable.luigi,  // Cambia esto con el recurso real de la imagen de Luigi
        R.drawable.peach,  // Cambia esto con el recurso real de la imagen de Peach
        R.drawable.toad    // Cambia esto con el recurso real de la imagen de Toad
    )
    inner class ViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        var image : ImageView
        var name : TextView
        var detail : TextView

        init {
            image = itemView.findViewById(R.id.image)
            name = itemView.findViewById(R.id.charname)
            detail = itemView.findViewById(R.id.text)
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
       val li = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(li)

    }


    override fun getItemCount(): Int {
      return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
         holder.name.text = names[i]
        holder.image.setImageResource(images[i])
        holder.detail.text = details[i]
    }
}