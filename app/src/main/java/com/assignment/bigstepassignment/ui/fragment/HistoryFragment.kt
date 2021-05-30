package com.assignment.bigstepassignment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.assignment.bigstepassignment.R
import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.assignment.bigstepassignment.ui.adapter.HistoryListRecyclerAdapter
import com.assignment.bigstepassignment.ui.adapter.VideoListRecyclerAdapter
import com.assignment.bigstepassignment.ui.viewmodel.HistoryViewModel
import com.assignment.bigstepassignment.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_video_list.*

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private val mViewModel: HistoryViewModel by viewModels()
    private lateinit var adapter: HistoryListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history_layout, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        mViewModel.getItemVisited().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    if (!it.data?.isNullOrEmpty()!!) adapter.setItems(it.data as ArrayList<VideoDetails>)
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
                Status.LOADING ->
                    progressBar.visibility = View.VISIBLE
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = HistoryListRecyclerAdapter()
        recyclerView.adapter = adapter
    }
}