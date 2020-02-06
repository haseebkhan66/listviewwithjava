package com.example.listviewwithjava

import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    var listView: ListView? = null
    var adapter: ListViewAdapter? = null
    lateinit var title: Array<String>
    lateinit var description: Array<String>
    lateinit var icon: IntArray
    var arrayList = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar!!.setTitle("Employee List ")
        title = arrayOf("Sir Waseem", "Sir Hammad", "Sir Ihsan", "Sir Umair",
                "Mam Annie", "Sir Ubaid", "Mam Khurria", "Sir Sifat", "Sir Ali")
        description = arrayOf("CEO", "CEO", "CEO", "MANAGER", "URRAN LEAD", "FINANCE MANAGER",
                "ANDROID LEAD", "ANDROID LEAD", "SPOTTER LEAD")
        icon = intArrayOf(
                R.drawable.s1,
                R.drawable.s2
                , R.drawable.s3,
                R.drawable.s4,
                R.drawable.g1,
                R.drawable.s5
                , R.drawable.g2,
                R.drawable.s1,
                R.drawable.s2
        )
        listView = findViewById(R.id.listView)
        for (i in title.indices) {
            val model = Model(title[i], description[i], icon[i])
            //bind all String in an array
            arrayList.add(model)
        }
        //Pass result to ListView Adapter class
        adapter = ListViewAdapter(this, arrayList)
        //bind the adapter to the listview
        listView?.setAdapter(adapter)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val myactionmenuitem = menu.findItem(R.id.action_search)
        val searchView = myactionmenuitem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (TextUtils.isEmpty(newText)) {
                    adapter!!.filter("")
                    listView!!.clearTextFilter()
                } else {
                    adapter!!.filter(newText)
                }
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_setting) {
            false
        } else super.onOptionsItemSelected(item)
    }
}