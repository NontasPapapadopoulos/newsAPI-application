package com.example.newsapiclient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.data.util.Resource
import com.example.newsapiclient.databinding.FragmentSavedBinding
import com.example.newsapiclient.presentation.adapter.NewsAdapter
import com.example.newsapiclient.presentation.viewmodel.NewsViewModel
import com.google.android.material.snackbar.Snackbar


class SavedFragment : Fragment() {

    private lateinit var fragmentSavedBinding: FragmentSavedBinding
    private lateinit var savedNewsAdapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentSavedBinding = FragmentSavedBinding.bind(view)
        savedNewsAdapter = (activity as MainActivity).newsAdapter
        viewModel = (activity as MainActivity).viewModel

        savedNewsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_article", it)
            }
            findNavController().navigate(R.id.action_savedFragment_to_infoFragment, bundle)
        }
        initRecyclerView()
        fetchSavedNewsFromLocalDB()
        val itemTouchHelperCallback = createItemTouchHelperCallback(view)
        attachItemTouchHelperToRecyclerView(itemTouchHelperCallback)

    }

    private fun fetchSavedNewsFromLocalDB() {
        viewModel.getSavedNews().observe(viewLifecycleOwner) {
            savedNewsAdapter.differ.submitList(it)
        }
    }

    private fun createItemTouchHelperCallback(view: View) :ItemTouchHelper.SimpleCallback {
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val article = savedNewsAdapter.differ.currentList[position]
                viewModel.deleteSavedArticle(article)
                Snackbar.make(view, "Deleted Successfully", Snackbar.LENGTH_LONG).apply {
                    setAction("Undo") {
                        viewModel.saveArticle(article)
                    }
                    show()
                }
            }

        }
        return itemTouchHelperCallback
    }

    private fun attachItemTouchHelperToRecyclerView(itemTouchHelperCallback: ItemTouchHelper.SimpleCallback) {
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(fragmentSavedBinding.savedNewsRecyclerView)
        }
    }

    private fun initRecyclerView() {
        fragmentSavedBinding.savedNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = savedNewsAdapter
        }
    }

}