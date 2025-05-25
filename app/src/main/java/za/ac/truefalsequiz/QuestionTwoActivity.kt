package za.ac.truefalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionTwoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_two)

        val previousScore = intent.getIntExtra("score", 0)
        val answer1 = intent.getStringExtra("answer1") ?: "Not answered"

        val nextButton: Button = findViewById(R.id.nextButton)
        val answerRadioGroup: RadioGroup = findViewById(R.id.answerRadioGroup)
        val falseRadioButton: RadioButton = findViewById(R.id.falseRadioButton)

        nextButton.setOnClickListener {
            val selectedId = answerRadioGroup.checkedRadioButtonId

            //check if there is no answer
            if (selectedId == -1) {
                Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            } else {
                val selectedAnswer = findViewById<RadioButton>(selectedId).text.toString()
                var score = previousScore
                if (selectedId == falseRadioButton.id) {
                    score++
                }

                val intent = Intent(this, QuestionThreeActivity::class.java)
                intent.putExtra("score", score)
                intent.putExtra("answer1", answer1)
                intent.putExtra("answer2", selectedAnswer)
                startActivity(intent)
            }
        }
    }
}