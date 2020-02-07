package com.cassiano.starwars.home.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cassiano.starwars.BR
import com.cassiano.starwars.R
import com.cassiano.starwars.home.adapter.PilotListAdapter
import com.cassiano.starwars.databinding.ActivityMainBinding
import com.cassiano.starwars.extension.bindingContentView
import com.cassiano.starwars.extension.observe
import com.cassiano.starwars.extension.withViewModel
import com.cassiano.starwars.home.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    companion object {
        const val BUNDLE_PILOT = "BUNDLE_PILOT"
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = getString(R.string.last_trips)
        viewModel = withViewModel({ MainViewModel(application) }) {
            observe(responseData) {
                setRecyclerView()
            }
            observe(responseError) {
                setTryAgainVisibility()
            }
        }
        binding = bindingContentView(R.layout.activity_main).apply {
            setVariable(BR.viewModel, viewModel)
            setVariable(BR.onTryAgainClick, View.OnClickListener { tryAgain() })
        } as ActivityMainBinding
        viewModel.getData()
    }

    private fun setRecyclerView() {
        val listAdapter = PilotListAdapter(viewModel.list)
        binding.recyclerView.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }

        listAdapter.selectedPilot.observe(this@MainActivity, Observer {
            val intent = Intent(this, PilotDetailsActivity::class.java)
            intent.putExtra(BUNDLE_PILOT, it)
            startActivity(intent)
        })
    }

    private fun setTryAgainVisibility() {
        viewModel.tryAgainVisibility.set(View.VISIBLE)
    }

    private fun tryAgain() {
        viewModel.apply {
            getData()
            tryAgainVisibility.set(View.GONE)
        }

    }

}
