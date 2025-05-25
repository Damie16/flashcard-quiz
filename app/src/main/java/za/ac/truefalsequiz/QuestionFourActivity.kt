package za.ac.truefalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionFourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_four)

        val currentScore = intent.getIntExtra("score", 0)
        val answer1 = intent.getStringExtra("answer1") ?: "Not answered"
        val answer2 = intent.getStringExtra("answer2") ?: "Not answered"
        val answer3 = intent.getStringExtra("answer3") ?: "Not answered"

        val nextButton: Button = findViewById(R.id.nextButton)
        val answerRadioGroup: RadioGroup = findViewById(R.id.answerRadioGroup)
        val trueRadioButton: RadioButton = findViewById(R.id.trueRadioButton)


        nextButton.setOnClickListener {
            if (answerRadioGroup.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            } else {
                var newScore = currentScore
                val selectedAnswer = if (answerRadioGroup.checkedRadioButtonId == trueRadioButton.id) {
                    newScore++
                    "True"
                } else {
                    "False"
                }

                val intent = Intent(this, QuestionFiveActivity::class.java)
                intent.putExtra("score", newScore)
                intent.putExtra("answer1", answer1)
                intent.putExtra("answer2", answer2)
                intent.putExtra("answer3", answer3)
                intent.putExtra("answer4", selectedAnswer)
                startActivity(intent)
            }
        }
    }
}