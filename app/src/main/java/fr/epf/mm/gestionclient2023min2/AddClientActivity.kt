package fr.epf.mm.gestionclient2023min2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import android.widget.SeekBar.OnSeekBarChangeListener

private const val TAG = "AddClientActivity"


private const val AGE_MAX = 65


private const val AGE_MIN = 18

class AddClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_client)

        Log.d(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")

        val lastNameEditText = findViewById<EditText>(R.id.add_client_last_name_edittext)
        val addButton = findViewById<Button>(R.id.add_client_button)

        val genderRadioGroup = findViewById<RadioGroup>(R.id.add_client_gender_radiogroup)
        genderRadioGroup.check(R.id.add_client_gender_man_radiobutton)

        val ageTextView = findViewById<TextView>(R.id.add_client_age_textview)
        val ageSeekBar = findViewById<SeekBar>(R.id.add_client_age_seekbar)

        ageSeekBar.max=AGE_MAX- AGE_MIN

        ageSeekBar.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                ageTextView.text = (progress+ AGE_MIN).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) = Unit

            override fun onStopTrackingTouch(seekBar: SeekBar?) = Unit

        })

        val levelSpinner=findViewById<Spinner>(R.id.add_client_level_spinner)



        addButton.setOnClickListener {
            val message = getString(R.string.add_client_mesage_success, lastNameEditText.text)
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            Log.d("EPF", "Nom : ${lastNameEditText.text}")
            genderRadioGroup.check(R.id.add_client_gender_man_radiobutton)
            val gender =
                if (genderRadioGroup.checkedRadioButtonId == R.id.add_client_gender_man_radiobutton) 1 else 2
            Log.d(TAG, "genre : ${gender}")
            Log.d(TAG, "niveau : ${levelSpinner.selectedItem}")

        }
    }
}