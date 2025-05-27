package vcmsa.ci.a2024summativerunthrough

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_weather)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Variables
        //Arrays
        val daysOfTheWeek = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
        val minTemperature = intArrayOf(15,17,19,20,16,15,18)
        val maxTemperature = intArrayOf(23,25,26,27,30,26,27)
        val weatherConditions = arrayOf("Cloudy","Sunny","Windy","Hot","Rainy","Stormy","Foggy")

        //Views
        val averageTempTxt = findViewById<TextView>(R.id.averageTempTxt)
        val detailedViewBtn = findViewById<Button>(R.id.detailedViewBtn)
        val exitButton = findViewById<Button>(R.id.exitButton)

        val averageTempValue = getAverageTemperature(minTemperature,maxTemperature)
        averageTempTxt.text = "Average Temperature: ${averageTempValue}C"

        detailedViewBtn.setOnClickListener{
            val intent = Intent(this,DetailedActivity::class.java)
            intent.putExtra("days",daysOfTheWeek)
            intent.putExtra("minTemp",minTemperature)
            intent.putExtra("maxTemp",maxTemperature)
            intent.putExtra("conditions",weatherConditions)
            startActivity(intent)
        }

    }
    fun getAverageTemperature(minTemp: IntArray, maxTemps: IntArray):Double {
        var totalMin = 0
        var totalMax = 0

        for (i in minTemp.indices){
            totalMin += minTemp[i]
            totalMax += maxTemps[i]
        }
        val averageMin = totalMin/minTemp.size
        val averageMax = totalMax/ maxTemps.size

        return (averageMin + averageMax)/2.0

    }
}