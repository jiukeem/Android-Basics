package com.example.wordsappbyme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsappbyme.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve the LETTER from the Intent extras
        // intent.extras.getString returns String? (String or null)
        // so toString() guarantees that the value will be a String
        // 인텐트에서 받아올 정보가 String 형식이기 때문에 ''가 아니라 ""
        val letterId = intent?.extras?.getString(LETTER).toString()

        /*
        intent는 디테일액티비티 소속도 아니고, 레터어댑터 소속도 아니다. 그래서 따로 정의하거나 임포트해올 필요 없다.
        It keeps a reference to the intent used to launch the activity.
        The intent property might not actually be an Intent (if the activity wasn't launched from an intent)
        그래서 뒤에 ? 가 붙는다. intent 나 extras 는 nullable 이기 때문.
        getString returns a String, so toString() is called to ensure it's a String, and not null.
         */

        val recyclerview = binding.detailRecyclerview
        recyclerview.adapter = WordAdapter(letterId, this)
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Adds a [DividerItemDecoration] between items
        // viewholder 간의 구분선을 말함
        recyclerview.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        title = getString(R.string.detail_prefix) + " " + letterId
    }
}