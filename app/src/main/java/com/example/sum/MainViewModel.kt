package com.example.sum

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var result = MutableLiveData<Int>()
    val getResult: LiveData<Int> = result
    private val score = ArrayList<ScoreItem>()
    private var scoreList = MutableLiveData<List<ScoreItem>?>()
    val getScoreList: LiveData<List<ScoreItem>?> = scoreList

    fun setSum(x: Int, y: Int) {

        val res = x + y
        val scoreItem = ScoreItem(
            res.toString()
        )
        score.add(scoreItem)
        scoreList.value = score
        result.value = res
    }

}