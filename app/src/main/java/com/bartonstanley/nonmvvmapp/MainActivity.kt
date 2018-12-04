package com.bartonstanley.nonmvvmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Activity that allows the user to enter a string and to immediately see the length of the string as each character is
 * entered (or deleted).
 *
 * This is the non-MVVM version of this Activity.
 */
class MainActivity : AppCompatActivity() {

    /**
     * Set the content view and put TextWatcher on EditText.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Request user input events
        editTextView.addTextChangedListener(Watcher())
    }

    /**
     * TextWatcher that reports user edits to the view model.
     */
    private inner class Watcher: TextWatcher {
        override fun afterTextChanged(s: Editable?) {

            // Put the length of the string into the TextView
            characterCountView.text = (s?:"").length.toString()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            // Not needed.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            // Not needed.
        }
    }
}
