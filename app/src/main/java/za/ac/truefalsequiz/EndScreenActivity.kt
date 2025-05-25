package za.ac.truefalsequiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EndScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.end_screen)

        val answer1 = intent.getStringExtra("answer1") ?: "Not answered"
        val answer2 = intent.getStringExtra("answer2") ?: "Not answered"
        val answer3 = intent.getStringExtra("answer3") ?: "Not answered"
        val answer4 = intent.getStringExtra("answer4") ?: "Not answered"
        val answer5 = intent.getStringExtra("answer5") ?: "Not answered"

        //display answers
        val answersTextView = findViewById<TextView>(R.id.answersTextView)
        answersTextView.text = """        
            Your Answers:
            Question 1: $answer1
            Question 2: $answer2
            Question 3: $answer3
            Question 4: $answer4
            Question 5: $answer5
        """.trimIndent()

        //initialzie restart button
        val restartButton: Button = findViewById(R.id.restartButton)
        restartButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            //close the end screen activity
            finish()
        }
    }
}