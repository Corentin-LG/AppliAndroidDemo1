package fr.epf.mm.gestionclient2023min2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val addButton = findViewById<Button>(R.id.home_add_button)
        val listButton = findViewById<Button>(R.id.home_list_button)
        addButton.setOnClickListener {
            val intent = Intent(this, AddClientActivity::class.java)
            startActivity(intent)
        }
        listButton.click {
            val intent = Intent(this, ListClientActivity::class.java)
            startActivity(intent)
        }
    }
}

fun View.click (action : (View) -> Unit){
    Log.d("CLICK", "click")
    this.setOnClickListener(action)
}