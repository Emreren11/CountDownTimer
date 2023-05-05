package com.emre.countdown

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.emre.countdown.databinding.ActivityMainBinding
import com.google.android.material.progressindicator.BaseProgressIndicator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        object : CountDownTimer(10000, 1000) { // Kaçtan geriye , kaç saniyede bir
            override fun onTick(millisUntilFinished: Long) {
                //Her bir saniyede (başta belirlenen sayma aralığı) ne yapılacak
                //millisUntilFinished -> verilen aralığı çıkarttığında kalan sayı
                binding.textView.text =
                    "Left: ${millisUntilFinished / 1000}" // 1000'e bölmemizin sebebi milisaniye cinsinden olduğu için
            }

            override fun onFinish() {
                //Bitince yapılacaklar
                binding.textView.text = "Left: 0"
            }

        }.start()
    }
}