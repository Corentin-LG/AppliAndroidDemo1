package fr.epf.mm.gestionclient2023min2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.mm.gestionclient2023min2.model.Client

class ListClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_client)

        val recyclerView = findViewById<RecyclerView>(R.id.list_client_recycleview)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = ClientAdapter(Client.all())
    }
}