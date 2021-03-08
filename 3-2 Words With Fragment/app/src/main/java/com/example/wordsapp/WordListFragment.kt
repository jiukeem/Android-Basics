package com.example.wordsapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    private var _binding: FragmentWordListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var letterId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setHasOptionsMenu(true)

        arguments?.let {
            letterId = it.getString(LETTER).toString()
            // 인텐트가 아니라 nav jetpack component의 safe arg 를 활용할 때는 onCreate 에서 작업한다.
            // argument 가 있다면 (아무것도 안 실었을 수도 있으니까)~ let + lambda 결국 if (argument) {} 와 똑같은듯?
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentWordListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.wordRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        recyclerView.adapter = WordAdapter(letterId, this.requireContext())
        // 액티비티에서와 다르게 그냥 intent.extras.getString~ 이런식으로 쓸 수 없다. 프래그먼트는 인텐트에 직접적인 접근이 불가하기 때문. 그래서 activity.intent 로 참조한다.

        recyclerView.addItemDecoration(
            DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}