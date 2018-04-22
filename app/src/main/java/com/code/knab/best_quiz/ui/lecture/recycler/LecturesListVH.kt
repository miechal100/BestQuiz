package com.code.knab.best_quiz.ui.lecture.recycler

import android.support.v7.widget.RecyclerView
import android.view.View
import com.code.knab.best_quiz.network.json.Lecture
import kotlinx.android.synthetic.main.vh_question_list.view.*

/**
 * Created by Michał on 21.04.2018.
 */
class LecturesListVH(view: View): RecyclerView.ViewHolder(view) {

    fun bind(lecture: Lecture) {
        this.itemView.vhQuestionContentTextView.text = lecture.name
        this.itemView.vhQuestionListDateAuthorTextView.text = "${lecture.day.name}:${lecture.startDate}-${lecture.finishDate}, ${lecture.abbreviation}"
    }
}