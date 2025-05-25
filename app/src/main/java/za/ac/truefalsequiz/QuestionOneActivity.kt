package za.ac.truefalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_one)

        var score = 0

        val nextButton: Button = findViewById(R.id.nextButton)
        val answerRadioGroup: RadioGroup = findViewById(R.id.answerRadioGroup)
        val trueRadioButton: RadioButton = findViewById(R.id.trueRadioButton)

        nextButton.setOnClickListener {
            val selectedId = answerRadioGroup.checkedRadioButtonId

            //check if no answer has been chosen
            if (selectedId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            } else {
                //get the text of the selected answer
                val selectedAnswer = findViewById<RadioButton>(selectedId).text.toString()

                // Increase score if answer is correct
                if (selectedId == trueRadioButton.id) {
                    score = 1
                }

                // Move to Question 2 and pass score + answer1
                val intent = Intent(this, QuestionTwoActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("answer1", selectedAnswer)
                startActivity(intent)
            }
        }
    }
}