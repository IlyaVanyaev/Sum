package com.example.sum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Score : Fragment() {

    private lateinit var adapter: ScoreAdapter
    private val scoreList = ArrayList<ScoreItem>()
    private val vm: MainViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        vm.getScoreList.observe(viewLifecycleOwner){
            it?.forEach { element ->
                scoreList.add(ScoreItem(element.score))
            }
            adapter.submitList(scoreList)
        }

    }

    private fun setRecyclerView(){
        val rv = view?.findViewById<RecyclerView>(R.id.score)
        rv?.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        adapter = ScoreAdapter()
        rv?.adapter = adapter

    }

}