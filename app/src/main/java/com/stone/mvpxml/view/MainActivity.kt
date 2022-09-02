package com.stone.mvpxml.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.stone.mvpxml.MyAdapters
import com.stone.mvpxml.databinding.ActivityMainBinding
import com.stone.mvpxml.inerfaces.ApiService
import com.stone.mvpxml.inerfaces.Pinterface
import com.stone.mvpxml.inerfaces.Posts
import com.stone.mvpxml.model.MainActivityMOdel
import com.stone.mvpxml.presenter.MainActivitypreseeter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Pinterface.MyViews {

    @Inject
    lateinit var apiService: ApiService

    private lateinit var presenter: MainActivitypreseeter

    private var _binding:ActivityMainBinding?=null
    private val binding:ActivityMainBinding
        get() = _binding!!
    private val mainAdapter = MyAdapters()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainActivitypreseeter(this, MainActivityMOdel(apiService))
        binding.recyclerView.layoutManager= LinearLayoutManager(this)

        initView()

    }
        private fun initView() {

            val x=Posts(12,21,"a.toString()","dsds")

            presenter.getposts()
            binding.recyclerView.adapter = mainAdapter
            binding.button.setOnClickListener { postdata(x) }
        }
        override fun onLoading() {
            binding.progress.visibility= View.VISIBLE
        }
    override fun postdata(posts: Posts) {
        var a= binding.editTextTextPersonName.text
        val x=Posts(12,21,a.toString(),"dsds")
        presenter.postdata(x)
    }
    override fun onSuccess(list: List<Posts>) {
            binding.progress.visibility= View.GONE
            mainAdapter.setdata(list)
        }
        override fun onError(msg: String) {
            binding.progress.visibility= View.GONE
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
        }

    override fun onsettext(text: String, name: String, id: Int, Idw: Int) {
 val x=    binding.editTextTextPersonName.text
      val aatext= binding.editTextTextPersonName.text.toString()
      val adtext= binding.editTextTextPersonName.text.toString()
      val atgext= binding.editTextTextPersonName.text.toString()

    }

    override fun onDestroy() {
            presenter.onDestroy()
            super.onDestroy()
        }
    }