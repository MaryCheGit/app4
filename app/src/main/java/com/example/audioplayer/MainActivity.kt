package com.example.audioplayer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutEmpty: View
    private lateinit var fabAdd: FloatingActionButton

    // Фейковый список треков
    private val fakeTracks = listOf(
        Track(1, "Somebody Told Me", "The Killers", "6:23", android.R.drawable.ic_media_play),
        Track(2, "No Distance Left To Run", "Blur", "4:49", android.R.drawable.ic_media_play),
        Track(3, "Fuckin' In The Bushes", "Oasis", "3:18", android.R.drawable.ic_media_play),
        Track(4, "Mr. Brightside", "The Killers", "4:43", android.R.drawable.ic_media_play),
        Track(5, "Wonderwall", "Oasis", "5:02", android.R.drawable.ic_media_play),
        Track(6, "Seaside", "The Kooks", "4:53", android.R.drawable.ic_media_play),
        Track(7, "There Are Too Many of Us", "Blur", "5:02", android.R.drawable.ic_media_play),
        Track(8, "Enterlude", "The Killers", "4:49", android.R.drawable.ic_media_play),
        Track(9, "Forgive & Forget", "The Kooks", "3:18", android.R.drawable.ic_media_play)
    )

    // Переключатель: true = показать пустой экран, false = показать список
    // Поменяйте значение, чтобы проверить оба состояния
    private var isEmptyState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        layoutEmpty = findViewById(R.id.layoutEmpty)
        fabAdd = findViewById(R.id.fabAdd)

        // Настраиваем RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TrackAdapter(fakeTracks)

        // Управляем видимостью экранов
        if (isEmptyState) {
            layoutEmpty.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            layoutEmpty.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }

        // Кнопка "+" — пока ничего не делает
        fabAdd.setOnClickListener {

        }
    }
}