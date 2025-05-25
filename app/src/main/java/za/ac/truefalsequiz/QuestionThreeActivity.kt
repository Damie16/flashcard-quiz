package za.ac.truefalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class QuestionThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question_three)

        val currentScore = intent.getIntExtra("score", 0)
        val answer1 = intent.getStringExtra("answer1") ?: "Not answered"
        val answer2 = intent.getStringExtra("answer2") ?: "Not answered"

        val nextButton: Button = findViewById(R.id.nextButton)
        val answerRadioGroup: RadioGroup = findViewById(R.id.answerRadioGroup)
        val trueRadioButton: RadioButton = findViewById(R.id.trueRadioButton)


        nextButton.setOnClickListener {
            //check if no answer has been selected
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

                //used to go to the next screen
                val intent = Intent(this, QuestionFourActivity::class.java)
                intent.putExtra("score", newScore)
                intent.putExtra("answer1", answer1)
                intent.putExtra("answer2", answer2)
                intent.putExtra("answer3", selectedAnswer)
                startActivity(intent)
            }
        }
    }
}