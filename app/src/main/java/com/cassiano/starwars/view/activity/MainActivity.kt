package com.cassiano.starwars.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.adapter.PilotListAdapter
import com.cassiano.starwars.databinding.ActivityMainBinding
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.extension.observe
import com.cassiano.starwars.extension.withViewModel
import com.cassiano.starwars.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = withViewModel({ MainViewModel(application) }) {
            observe(responseData) {
                setRecyclerView()
            }
        }
        binding = bindingContentView(R.layout.activity_main).also { it.setVariable(BR.viewModel, viewModel) } as ActivityMainBinding
        viewModel.getData()
    }

    private fun setRecyclerView() {
        binding.recyclerView
        val listAdapter = PilotListAdapter(viewModel.list)
        binding.recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }

        listAdapter.selectedPilot.observe(this@MainActivity, Observer {
            val intent = Intent(this, PilotDetailsActivity::class.java)
            intent.putExtra("PILOT", it)
            startActivity(intent)
        })
    }
}
