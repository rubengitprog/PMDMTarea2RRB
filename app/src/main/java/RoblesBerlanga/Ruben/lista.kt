package RoblesBerlanga.Ruben

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class lista : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = Adapter(object : OnItemClickListener{
            override fun onItemClick(position: Int) {
               Toast.makeText(this@lista,"Has pulsado $position", Toast.LENGTH_SHORT).show()
            }

        })

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

    }
}