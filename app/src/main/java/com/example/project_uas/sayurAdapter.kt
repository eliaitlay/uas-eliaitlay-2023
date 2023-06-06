package com.example.project_uas
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class sayurAdapter(private val context: Context, private  val Dutapapua: List<Sayur>, val listener:(Sayur) ->Unit)
    : RecyclerView.Adapter<sayurAdapter.DutapapuaViewHolder>(){

    class DutapapuaViewHolder (view: View):RecyclerView.ViewHolder(view) {



        val imgSayur = view.findViewById<ImageView>(R.id.img_sayur)

        val nameSayur = view.findViewById<TextView>(R.id.tv_namasayur)
        val descSayur = view.findViewById<TextView>(R.id.tv_descsayur)

        fun bindView(dutapapua: Sayur, listener: (Sayur) -> Unit) {
            imgSayur.setImageResource(dutapapua.imgsayur)
            nameSayur.text = dutapapua.namasayur
            descSayur.text = dutapapua.dessayur
            itemView.setOnClickListener {
                listener(dutapapua)
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DutapapuaViewHolder {
        return DutapapuaViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_data, parent, false)
        )
    }

    override fun getItemCount(): Int = Dutapapua.size


    override fun onBindViewHolder(holder: DutapapuaViewHolder, position: Int) {
        holder.bindView(Dutapapua[position],listener)
    }


}





