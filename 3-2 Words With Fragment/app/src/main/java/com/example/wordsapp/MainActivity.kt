/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.wordsapp.databinding.ActivityMainBinding

/**
 * Main Activity and entry point for the app. Displays a RecyclerView of letters.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        // This ensures action bar (app bar) buttons, like the menu option in LetterListFragment are visible.
        setupActionBarWithNavController(navController)

        // 프래그먼트를 따로 연결해줄 필요 없이 그냥 프래그먼트가 보여질 수 있도록 인플레이트만 하면 되네?
        // 흠... 이러면 프레그먼트 onCreate()는 어떻게 알고 호출되는거지?
        // 연결된 activity_main 에 fragment container view 를 넣어줬다! 그리고 이걸 nave host로 지정해주고 nav graph.xml 을 연결해주면 nav graph 안에 두 프래그먼트가 있으니 활동할 수 있다
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}

