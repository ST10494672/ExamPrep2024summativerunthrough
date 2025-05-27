package vcmsa.ci.a2024summativerunthrough

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        //variables
        val goButton=findViewById<AppCompatButton>(R.id.goButton)
        val exitButton =findViewById<AppCompatButton>(R.id.exitButton)

        //On click listener
        goButton.setOnClickListener
        val intent = Intent(this,WeatherActivity::class.java)
        startActivity(Intent)
        }
        exitbutton.setOnClickListener {
            finishAffinity() // close the app
        }
    }
}