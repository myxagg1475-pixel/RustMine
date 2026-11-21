
package com.rustmine.launcher

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.gravity = Gravity.CENTER
        layout.setPadding(28, 32, 28, 32)
        layout.setBackgroundColor(Color.rgb(18, 18, 18))

        fun addText(text: String, size: Float, color: Int) {
            val view = TextView(this)
            view.text = text
            view.textSize = size
            view.setTextColor(color)
            view.gravity = Gravity.CENTER
            view.setPadding(8, 16, 8, 16)
            layout.addView(view)
        }

        fun addButton(text: String, message: String) {
            val button = Button(this)
            button.text = text
            button.setTextColor(Color.WHITE)
            button.setBackgroundColor(Color.rgb(210, 85, 25))
            button.setOnClickListener {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 10, 0, 10)
            layout.addView(button, params)
        }

        addText("RUSTMINE", 36f, Color.rgb(255, 112, 35))
        addText("MINECRAFT JAVA LAUNCHER", 15f, Color.WHITE)
        addText("ANDROID EDITION", 13f, Color.GRAY)

        addText("Minecraft Java 1.21.1", 20f, Color.WHITE)

        addButton("PLAY", "Запуск гри буде додано пізніше")
        addButton("МОДИ", "Керування модами буде додано пізніше")
        addButton("ТЕКСТУРИ", "Текстури буде додано пізніше")
        addButton("НАЛАШТУВАННЯ", "RustMine Settings")

        setContentView(layout)
    }
}
