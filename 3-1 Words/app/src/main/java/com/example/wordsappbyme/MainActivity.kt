package com.example.wordsappbyme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsappbyme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var isLinearLayoutManager = true
    private lateinit var recyclerview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerview = binding.mainRecyclerview
        chooseLayout()
    }

    /**
     * layoutManager 와 Adapter 지정
     */
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerview.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerview.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerview.adapter = LetterAdapter()
    }

    /**
     * isLinearLayoutManager에 따라 아이콘 이미지 지정
     */
    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
        /*
        The above code is equivalent to
        if (isLinearLayoutManager)
             menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
        else menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
        */
    }

    /**
     * Initializes the [Menu] to be used with the current [Activity]
     * where you inflate the options menu and perform any additional setup
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        return true
    }

    /**
     * Determines how to handle interactions with the selected [MenuItem]
     * where you'll actually call chooseLayout() when the button is selected.
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 눌린 아이템이 action_switch_layout, 즉 메뉴아이콘일 때, isLinearLayoutManager 을 바꾸고, 그에 맞춰서 레이아웃매니저를 바꾸고 아이콘을 재설정함.
        // 내가 호출하는게 아니라 메뉴아이템이 눌릴 때 자동으로 호출됨
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            // when 구문은 else 가 꼭 필요하므로 여기에는 super 해주자
            else -> super.onOptionsItemSelected(item)
        }
    }
}