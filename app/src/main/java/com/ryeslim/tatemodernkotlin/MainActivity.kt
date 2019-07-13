package com.ryeslim.tatemodernkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    internal val NUMBER_OF_QUESTIONS = 4

    // no questions are answered at the beginning,
    // thus initially all the values are false by default
    internal var answeredQuestion = BooleanArray(NUMBER_OF_QUESTIONS)
    internal var point = intArrayOf(0, 0, 0, 0) //points for answers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * @param view; this method is called when Question 1 is answered,
     * ie button CHOOSE is clicked
     */
    fun question1(view: View) {

        answeredQuestion[0] = true //yes, now Question 1 is answered

        val radioGroup = findViewById(R.id.radio_group_1) as RadioGroup
        //checks if the answer is correct
        val radioButton1 = findViewById(R.id.answer_1_3) as RadioButton
        if (radioGroup.getCheckedRadioButtonId() == radioButton1.getId())
            point[0] = 1
        else
            point[0] = 0
        //oops, now it is false (although you may have chosen the right answer before)
    }

    /**
     * @param view; this method is called when Question 1 is answered,
     * ie button CHOOSE is clicked
     */
    fun question2(view: View) {

        answeredQuestion[1] = true //yes, now Question 1 is answered

        val radioGroup = findViewById(R.id.radio_group_2) as RadioGroup

        //checks if the answer is correct
        val radioButton2 = findViewById(R.id.answer_2_1) as RadioButton
        if (radioGroup.getCheckedRadioButtonId() == radioButton2.getId())
            point[1] = 1
        else
            point[1] = 0
        //oops, now it is false (although you may have chosen the right answer before)
    }

    /**
     * @param view; this method is called when Question 3 is answered,
     * ie button CHOOSE is clicked
     */
    fun question3(view: View) {

        answeredQuestion[2] = true //yes, now Question 3 is answered

        val answer_3_1 = findViewById(R.id.answer_3_1) as CheckBox
        val answer_3_1_Chosen = answer_3_1.isChecked()

        val answer_3_2 = findViewById(R.id.answer_3_2) as CheckBox
        val answer_3_2_Chosen = answer_3_2.isChecked()

        val answer_3_3 = findViewById(R.id.answer_3_3) as CheckBox
        val answer_3_3_Chosen = answer_3_3.isChecked()

        val answer_3_4 = findViewById(R.id.answer_3_4) as CheckBox
        val answer_3_4_Chosen = answer_3_4.isChecked()

        // checks if the answer is correct
        if (answer_3_1_Chosen && answer_3_3_Chosen && !answer_3_2_Chosen && !answer_3_4_Chosen)
            point[2] = 1
        else
            point[2] = 0
        //oops, now it is false (although you may have chosen the right answer before)
    }

    /**
     * @param view; this method is called when Question 4 is answered,
     * ie button CHOOSE is clicked
     */
    fun question4(view: View) {

        answeredQuestion[3] = true //yes, now Question 4 is answered

        val answer_4 = findViewById(R.id.answer_4) as EditText
        val answer_4_Correct = answer_4.getText().toString()
        if (answer_4_Correct.trim({ it <= ' ' }) == "2016")
        // trims spaces and checks if the answer is correct
            point[3] = 1
        else
            point[3] = 0
        //oops, now it is false (although you may have chosen the right answer before)
    }

    fun theScore(view: View) {

        var score = 0

        val encouragement = arrayOfNulls<String>(NUMBER_OF_QUESTIONS + 1)

        encouragement[0] = getString(R.string.encouragement_0)
        encouragement[1] = getString(R.string.encouragement_1)
        encouragement[2] = getString(R.string.encouragement_2)
        encouragement[3] = getString(R.string.encouragement_3)
        encouragement[4] = getString(R.string.encouragement_4)

        for (i in 0 until NUMBER_OF_QUESTIONS) {
            if (!answeredQuestion[i]) {
                Toast.makeText(applicationContext, R.string.questions_omitted, Toast.LENGTH_LONG).show()
                return
            } else {
                score += point[i]
            }
        }
        val theMessage = ("Your score is " + score + "/" + NUMBER_OF_QUESTIONS + " "
                + encouragement[score] + " " + getString(R.string.encouragement_to_all))

        Toast.makeText(applicationContext, theMessage, Toast.LENGTH_LONG).show()
        return
    }
}

