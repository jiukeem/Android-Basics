package com.example.wordsapp

import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    private var _binding: FragmentLetterListBinding? = null
    // 아래의 과정을 통해 모든 구문에서 ?를 붙이지 않아도 되게 만들 수 있다.
    // 이걸 여기에 써놓는거 보니 _binding 이 변경되면 binding 도 계속 변경되나 본데???
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false) // 액티비티에서 할 때는 그냥 layoutInflater 파라미터 한개였는데 왜 여기는 다를까?
        val view = binding.root
        return view
    }
    /*
    액티비티에서는 이랬다.
    binding = ActivityLetterListBinding.inflate(layoutInflater)
    setContentView(binding.root)
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.letterRecyclerView
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }
    /*
    액티비티와 다름. 우선 global property 인 menuInflater 가 없고, 얘는 아무것도 리턴하지 않는다.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
     */


    // 저 안에 this.requireContext()와 context가 어떻게 다를까?
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 4)
        }
        recyclerView.adapter = LetterAdapter()
    }

    private fun setIcon(item: MenuItem?) {
        if (item == null) {
            return
        }
        item.icon =
            if (isLinearLayoutManager) ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
        else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                setIcon(item)
                chooseLayout()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}