package com.florm.ualaapp.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.florm.ualaapp.R
import com.florm.ualaapp.models.Meal
import com.florm.ualaapp.viewmodels.ListViewModel

class ListActivity : AppCompatActivity(), ListAdapter.ListActivityBridge {

    private lateinit var viewModel : ListViewModel
    private var listRecyclerView: RecyclerView? = null
    private var listAdapter: ListAdapter? = null
    private var searchEditText: EditText? = null
    private var randomFragment: RandomFragment? = null
    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        bindViewElements()
        createViewModel()
        observeViewModel()
        addListeners()
        createFragmentInstance()
        initFragment()

    }

    private fun bindViewElements() {
        listRecyclerView = findViewById(R.id.rv_list)
        progressBar = findViewById(R.id.progress_bar)
        searchEditText = findViewById(R.id.et_search)
    }

    private fun createViewModel() {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
    }

    private fun observeViewModel() {
        viewModel.mealsList.observe(this, Observer<List<Meal>> {
            loadList(it)
        })
    }

    private fun addListeners() {
        searchEditText?.doOnTextChanged { text, start, count, after ->
            listAdapter?.searchMeal(text.toString())
        }
    }

    private fun loadList(list: List<Meal>) {
        listAdapter = ListAdapter(list.toMutableList(), this)
        listRecyclerView?.layoutManager = LinearLayoutManager(this)
        listRecyclerView?.adapter = listAdapter

        progressBar?.visibility = View.GONE
    }

    override fun onItemClicked(item: Meal) {
        goToDetailActivity(item)
    }

    private fun goToDetailActivity(item: Meal) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("EXTRA_MEAL", item)
        startActivity(intent)
    }

    private fun createFragmentInstance() {
        viewModel.let {
            randomFragment = RandomFragment.newInstance(it)
        }
    }

    private fun initFragment() {
        randomFragment?.let {
            supportFragmentManager.beginTransaction().add(R.id.random_fragment, it).commit()
        }
    }

}