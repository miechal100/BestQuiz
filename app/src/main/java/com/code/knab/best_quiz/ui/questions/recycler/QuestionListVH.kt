package com.code.knab.best_quiz.ui.questions.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.code.knab.best_quiz.network.json.Question
import kotlinx.android.synthetic.main.vh_question_list.view.*

/**
 * Created by Michał on 21.04.2018.
 */
class QuestionListVH(view: View): RecyclerView.ViewHolder(view) {

    fun bind(question: Question) {
        this.itemView.vhQuestionContentTextView.text = question.content
        this.itemView.vhQuestionListDateAuthorTextView.text = question.createdAt.toString()
    }
}