package com.android.code.test.myapplication.network.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.code.test.R
import com.android.code.test.databinding.PostListLayoutBinding
import com.android.code.test.myapplication.network.viewmodel.ViewModel
import com.android.code.test.myapplication.network.viewmodel.RetroViewModelFactory

class RetroFragment: Fragment() {

    private lateinit var viewModel: ViewModel
    private var listAdapter:PostListAdapter? = null
    private lateinit var postListLayoutBinding: PostListLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        postListLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.post_list_layout,container,false)
        return postListLayoutBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        setAdapter()
        fetchRetroInfo()
    }

    private fun initViewModel(){
        val retroViewModelFactory = RetroViewModelFactory()
        viewModel = ViewModelProvider(this,retroViewModelFactory).get(ViewModel::class.java)
    }

    private fun fetchRetroInfo(){
        viewModel.infoLiveData.observe(viewLifecycleOwner) { t -> t.apply {
                listAdapter?.setAdapterList(t)
            }
        }
    }

    private fun setAdapter(){
        postListLayoutBinding.postList.apply {
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
            adapter = listAdapter
        }
    }

   private fun initAdapter(){
       listAdapter = PostListAdapter(this@RetroFragment.requireActivity())
   }
}