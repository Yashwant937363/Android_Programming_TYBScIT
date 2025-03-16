package com.example.android_programming_tybscit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class StudentListAdapter(val list:JSONArray, val context:Context): BaseAdapter() {
    override fun getCount(): Int {
        return list.length()
    }

    override fun getItem(position: Int): JSONObject {
        return  list.getJSONObject(position)
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val listItemView = LayoutInflater.from(context).inflate(R.layout.student_listitem_layout, parent, false)
        val listItem:JSONObject = getItem(position)
        listItemView.findViewById<TextView>(R.id.rno).text = listItem.getInt("rno").toString()
        listItemView.findViewById<TextView>(R.id.name).text = listItem.getString("name")
        listItemView.findViewById<TextView>(R.id.grade).text = listItem.getString("grade")
        return listItemView
    }
}