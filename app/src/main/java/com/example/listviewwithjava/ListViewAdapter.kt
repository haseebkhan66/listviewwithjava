package com.example.listviewwithjava

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class ListViewAdapter(//  variables
var mcontext: Context, var modelList: MutableList<Model>) : BaseAdapter() {
    var inflater: LayoutInflater
    var arrayList: ArrayList<Model>

    //View Holder class
    inner class ViewHolder {
        var nTitle: TextView? = null
        var nDesc: TextView? = null
        var nIconIV: ImageView? = null
    }

    override fun getCount(): Int {
        return modelList.size
    }

    override fun getItem(position: Int): Any {
        return modelList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            convertView = inflater.inflate(R.layout.row, null)
            //Locate the row in the row.xml
            holder.nTitle = convertView.findViewById(R.id.mainTitle)
            holder.nDesc = convertView.findViewById(R.id.mainDescription)
            holder.nIconIV = convertView.findViewById(R.id.mainIcon)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        //Set the result into text view
        holder.nTitle!!.text = modelList[position].title
        holder.nDesc!!.text = modelList[position].desc
        //set the result in image view
        holder.nIconIV!!.setImageResource(modelList[position].icon)
        //Listview Item clicks
        convertView?.setOnClickListener {
            //CODE LATER IN THIS CLICK LISTENENR
            if (modelList[position].title == "Sir Waseem") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Sir Waseem")
                intent.putExtra("ContentTv", "Sir Waseem Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Sir Hammad") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Sir Hammad")
                intent.putExtra("ContentTv", "Sir Hammad Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Sir Ihsan") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Sir Ihsan")
                intent.putExtra("ContentTv", "Sir Ihsan Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Sir Umair") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Sir Umair")
                intent.putExtra("ContentTv", "Sir Umair Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Mam Annie") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Mam Annie")
                intent.putExtra("ContentTv", "Mam Annie Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Sir Ubaid") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Sir Ubaid")
                intent.putExtra("ContentTv", "Sir Ubaid Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Mam Khurria") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Mam Khurria")
                intent.putExtra("ContentTv", "Mam Khurria Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Sir Sifat") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Sir Sifat")
                intent.putExtra("ContentTv", "Sir Sifat Details")
                mcontext.startActivity(intent)
            }
            if (modelList[position].title == "Sir Ali") {
                val intent = Intent(mcontext, NewActivity::class.java)
                intent.putExtra("ActionBarTitle", "Sir Ali")
                intent.putExtra("ContentTv", "Sir Ali Details")
                mcontext.startActivity(intent)
            }
        }
        return convertView!!
    }

    //FILTER METHOD
    fun filter(charText: String) {
        var charText = charText
        charText = charText.toLowerCase(Locale.getDefault())
        modelList.clear()
        if (charText.length == 0) {
            modelList.addAll(arrayList)
        } else {
            for (model in arrayList) {
                if (model.title.toLowerCase(Locale.getDefault()).contains(charText)) {
                    modelList.add(model)
                }
            }
        }
        notifyDataSetChanged()
    }

    //Constructor
    init {
        inflater = LayoutInflater.from(mcontext)
        arrayList = ArrayList()
        arrayList.addAll(modelList)
    }
}