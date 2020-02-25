package com.example.mostpopularapp.ui.mplist.view
import AppsAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import android.widget.EditText
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mostpopularapp.R
import com.example.mostpopularapp.ui.base.BaseActivity
import com.example.mostpopularapp.ui.mplist.ItemsViewModel
import com.example.mostpopularapp.ui.mplist.adapter.listener.ItemsListener
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import com.example.mostpopularapp.ui.mplist.models.Result
import com.example.mostpopularapp.utilities.VerticalSpace
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.charset.StandardCharsets
import kotlin.collections.ArrayList

class ItemsListActivity : BaseActivity(), ItemsListener {

    var searchET: EditText? = null
    private var appViewModle: ItemsViewModel? = null
    private var appRecyclerAdapter: AppsAdapter? = null
    var query = ""
    var list : List<Result> ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        searchET!!.addTextChangedListener(generalTextWatcher)
        showLoadingDialog()
        appViewModle =
            ViewModelProviders.of(this).get(ItemsViewModel::class.java)
        appViewModle!!.getSubjects(7)
        appViewModle!!.getAppsCallback().observe(this, Observer {   initRecycler(  it)
        })


    }

    private fun initRecycler(listItems : MostPopularResponseObj) {
        hideLoadingDialog()
        list = listItems.results
        mostpop_list.layoutManager = LinearLayoutManager(this)
        // Access the RecyclerView Adapter and load the data into it
        mostpop_list.adapter = AppsAdapter( list as ArrayList<Result>,this@ItemsListActivity)
        //Update list with new list comes from server
        appRecyclerAdapter?.UpdateList( list as ArrayList<Result>)
        //Set Spaces between Items in Recycler
        mostpop_list!!.addItemDecoration(VerticalSpace(25))
    }

    override fun itemChoosen(Id: Int?) {
        val gson = Gson()
        val obj = gson.toJson(list!![Id!!])
        val i = Intent(this@ItemsListActivity, AppDetailsActivity::class.java)
        i.putExtra("obj", obj)
        startActivity(i)
    }
}



