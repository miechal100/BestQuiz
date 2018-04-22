package com.code.knab.best_quiz.ui.single_question.mvp

import com.code.knab.best_quiz.network.api.SingleQuestionApi
import com.code.knab.best_quiz.network.json.Question
import io.reactivex.Single

/**
 * Created by Michał on 22.04.2018.
 */
class SingleQuestionModel(private val api: SingleQuestionApi): SingleQuestionMVP.Model {
    override fun postAnswer(answerId: Int): Single<Any> =
            api.postAnswer(answerId)

    override fun getQuestion(questionId: Int): Single<Question> =
            api.getSingleQuestion(questionId)

}