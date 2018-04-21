package com.code.knab.best_quiz.ui.questions.recycler

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Question

/**
 * Created by Michał on 21.04.2018.
 */
class QuestionListAdapter(val clickItem: ItemClick): RecyclerView.Adapter<QuestionListVH>() {

    var list: List<Question> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): QuestionListVH {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.vh_question_list, parent, false)
        return QuestionListVH(view)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: QuestionListVH?, position: Int) {
        holder?.bind(list[position])

        holder?.itemView?.setOnClickListener{
            clickItem.open(list[position])
        }
    }

    fun replaceList(filter: List<Question>, diffResult: DiffUtil.DiffResult) {
        list = filter
        diffResult.dispatchUpdatesTo(this)
    }
}