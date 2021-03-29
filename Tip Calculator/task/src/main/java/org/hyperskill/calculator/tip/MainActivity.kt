package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var slider: Slider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_text)
        slider = findViewById(R.id.slider)
        slider.addOnChangeListener { _, _, _ ->  updateTextView()}
        editText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                updateTextView()
            }
        })
    }

    fun updateTextView() {
        val text = if (editText.text.toString() != "") "Tip amount: ${"%.2f".format(editText.text.toString().toFloat() * slider.value / 100)}" else ""
        findViewById<TextView>(R.id.text_view).setText(text)
    }
}