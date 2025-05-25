package za.ac.truefalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionFiveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_five)

        val currentScore = intent.getIntExtra("score", 0)

        val answer1 = intent.getStringExtra("answer1") ?: "Not answered"
        val answer2 = intent.getStringExtra("answer2") ?: "Not answered"
        val answer3 = intent.getStringExtra("answer3") ?: "Not answered"
        val answer4 = intent.getStringExtra("answer4") ?: "Not answered"

        val nextButton: Button = findViewById(R.id.nextButton)
        val answerRadioGroup: RadioGroup = findViewById(R.id.answerRadioGroup)
        val trueRadioButton: RadioButton = findViewById(R.id.trueRadioButton)


        nextButton.setOnClickListener {
            if (answerRadioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            } else {
                var finalScore = currentScore

                val selectedAnswer = if (answerRadioGroup.checkedRadioButtonId == trueRadioButton.id) {
                    finalScore++
                    "True"
                } else {
                    "False"
                }

                // Pass score and all answers to EndScreenActivity
                val intent = Intent(this, EndScreenActivity::class.java)
                intent.putExtra("score", finalScore)
                intent.putExtra("answer1", answer1)
                intent.putExtra("answer2", answer2)
                intent.putExtra("answer3", answer3)
                intent.putExtra("answer4", answer4)
                intent.putExtra("answer5", selectedAnswer)
                startActivity(intent)
            }
        }
    }
}