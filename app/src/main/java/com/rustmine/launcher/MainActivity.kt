package com.rustmine.launcher

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {
    private val background = Color.rgb(13, 14, 17)
    private val panel = Color.rgb(25, 27, 32)
    private val orange = Color.rgb(255, 112, 40)
    private var selectedVersion = "1.21.1"

    private fun forty() = 40

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showHome()
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

    private fun rounded(color: Int, radius: Int = 16): GradientDrawable =
        GradientDrawable().apply {
            setColor(color)
            cornerRadius = dp(radius).toFloat()
        }

    private fun text(value: String, size: Float, color: Int, bold: Boolean = false): TextView =
        TextView(this).apply {
            text = value
            textSize = size
            setTextColor(color)
            gravity = Gravity.CENTER
            if (bold) typeface = Typeface.DEFAULT_BOLD
            setPadding(dp(8), dp(8), dp(8), dp(8))
        }

    private fun showHome() {
        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(20), dp(26), dp(20), dp(24))
            setBackgroundColor(background)
        }

        page.addView(text("RUSTMINE", 34f, orange, true))
        page.addView(text("MINECRAFT JAVA LAUNCHER", 13f, Color.LTGRAY, true))
        page.addView(text("ANDROID EDITION  •  DEVELOPMENT BUILD", 10f, Color.GRAY))

        val versionCard = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            background = rounded(panel)
            setPadding(dp(16), dp(12), dp(16), dp(12))
        }
        versionCard.addView(text("ОБРАНА ВЕРСІЯ", 11f, Color.GRAY, true))
        versionCard.addView(text("Minecraft Java $selectedVersion", 20f, Color.WHITE, true))
        page.addView(versionCard, matchWrap().apply {
            topMargin = dp(28)
            bottomMargin = dp(18)
        })

        actionButton(page, "▶   PLAY", orange) {
            AlertDialog.Builder(this)
                .setTitle("RustMine")
                .setMessage("Ігровий рушій Minecraft Java ще не підключений. Ця версія — оновлена оболонка лаунчера; запуск гри стане доступним після інтеграції рушія та Java runtime.")
                .setPositiveButton("Зрозуміло", null)
                .show()
        }
        actionButton(page, "УВІЙТИ ЧЕРЕЗ MICROSOFT", panel) {
            info("Вхід Microsoft буде додано разом із модулем запуску Minecraft.")
        }
        actionButton(page, "МОДИ", panel) {
            info("Менеджер модів ще не підключений. Після інтеграції рушія тут з'явиться керування Fabric / Forge та файлами модів.")
        }
        actionButton(page, "ТЕКСТУРИ", panel) {
            info("Менеджер ресурс-паків ще не підключений. Тут буде встановлення та вибір текстурних паків.")
        }
        actionButton(page, "НАЛАШТУВАННЯ", panel) { showSettings() }

        page.addView(text("СТАН ПРОЄКТУ", 11f, orange, true).apply {
            gravity = Gravity.START
            setPadding(dp(4), dp(24), dp(4), dp(4))
        })
        page.addView(text("Інтерфейс RustMine готовий. Ігровий рушій, авторизація Microsoft і Java runtime ще потребують інтеграції.", 12f, Color.LTGRAY).apply {
            gravity = Gravity.START
        })

        val scroll = ScrollView(this).apply {
            isFillViewport = true
            addView(page)
        }
        setContentView(scroll)
    }

    private fun matchWrap(): LinearLayout.LayoutParams =
        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)

    private fun actionButton(parent: LinearLayout, label: String, color: Int, action: () -> Unit) {
        val button = TextView(this).apply {
            text = label
            textSize = 15f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
            background = rounded(color, 14)
            setPadding(dp(14), dp(17), dp(14), dp(17))
            isClickable = true
            isFocusable = true
            setOnClickListener { action() }
        }
        parent.addView(button, matchWrap().apply {
            topMargin = dp(7)
            bottomMargin = dp(7)
        })
    }

    private fun info(message: String) {
        AlertDialog.Builder(this)
            .setTitle("RustMine")
            .setMessage(message)
            .setPositiveButton("Добре", null)
            .show()
    }

    private fun showSettings() {
        AlertDialog.Builder(this)
            .setTitle("Налаштування")
            .setSingleChoiceItems(arrayOf("Minecraft Java 1.21.1 (обрана)"), 0, null)
            .setPositiveButton("Готово", null)
            .setNeutralButton("Про RustMine") { _, _ ->
                info("RustMine — Android-оболонка для майбутнього запуску Minecraft Java. Поточна збірка ще не запускає саму гру.")
            }
            .show()
    }
}
