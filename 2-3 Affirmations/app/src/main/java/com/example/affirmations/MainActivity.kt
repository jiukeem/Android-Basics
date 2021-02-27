package com.example.affirmations

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.adapter.ItemAdapter
import com.example.affirmations.data.Datasource
import com.example.affirmations.model.Affirmation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize data
        val myDataset: List<Affirmation> = Datasource().loadAffirmations()
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        // 리사이클러뷰에게 어댑터는 요걸 이용하라고 지정.
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes in content do not change the layout size of the RecyclerView
        // 추가적인 설정이며, 리사이클러뷰의 성능을 향상이킨다. 안의 컨텐트가 바뀌어도 리사이클러뷰의 사이즈가 변하지 않는다면 설정해주자.
        recyclerView.setHasFixedSize(true)
    }
}