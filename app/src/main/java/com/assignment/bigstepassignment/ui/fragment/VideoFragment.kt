package com.assignment.bigstepassignment.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.assignment.bigstepassignment.R
import com.assignment.bigstepassignment.data.entities.VideoDetails
import com.assignment.bigstepassignment.ui.activity.VideoDetailsActivity
import com.assignment.bigstepassignment.ui.adapter.VideoListRecyclerAdapter
import com.assignment.bigstepassignment.ui.viewmodel.VideoViewModel
import com.assignment.bigstepassignment.utils.Status
import kotlinx.android.synthetic.main.fragment_video_list.*

@AndroidEntryPoint
class VideoFragment : Fragment() {

    private val mViewModel by viewModels<VideoViewModel>()
    private lateinit var adapter: VideoListRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video_list, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        mViewModel.getVideoList().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    if (!it.data?.results.isNullOrEmpty()) adapter.setItems(ArrayList(it.data?.results))
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
        adapter = VideoListRecyclerAdapter { item: VideoDetails -> onItemClicked(item) }
        recyclerView.adapter = adapter
    }

    private fun onItemClicked(item : VideoDetails) {
        mViewModel.insertItemVisited(item)
        startActivity(VideoDetailsActivity.getIntent(requireContext(), item))
    }
}

