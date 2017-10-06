package me.rakshakhegde.ghumaoapp

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		ghumao.apply {
			text = "4578"
			textPaint.apply {
				color = Color.DKGRAY
				textSize = 50F
			}
		}
	}
}
