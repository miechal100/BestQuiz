package com.code.knab.best_quiz.ui.lecture.recycler

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.code.knab.best_quiz.R
import com.code.knab.best_quiz.network.json.Lecture
import com.code.knab.best_quiz.network.json.Question
import com.code.knab.best_quiz.ui.questions.recycler.ItemClick
import com.code.knab.best_quiz.ui.questions.recycler.QuestionListVH

/**
 * Created by Michał on 21.04.2018.
 */
class LecturesListAdapter(val clickItem: ItemClick<Lecture>): RecyclerView.Adapter<LecturesListVH>() {

    var list: List<Lecture> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LecturesListVH {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.vh_question_list, parent, false)
        return LecturesListVH(view)
    }

    override fun getItemCount(): Int = list.count()

    override fun onBindViewHolder(holder: LecturesListVH?, position: Int) {
        holder?.bind(list[position])

        holder?.itemView?.setOnClickListener{
            clickItem.open(list[position])
        }
    }

    fun replaceList(filter: List<Lecture>, diffResult: DiffUtil.DiffResult) {
        list = filter
        diffResult.dispatchUpdatesTo(this)
    }
}