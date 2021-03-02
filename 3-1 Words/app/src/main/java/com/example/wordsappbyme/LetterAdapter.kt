package com.example.wordsappbyme

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter: RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    // ['A', 'B', .... , 'Z']
    val list = ('A').rangeTo('Z').toList()

    // create viewholder class for adapter
    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.itemButton)
    }

    /**
     * Creates new views with R.layout.item_view as its template
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        layout.accessibilityDelegate = Accessibility
        return LetterViewHolder(layout)
    }

    override fun getItemCount() = list.size

    /**
     * Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list[position]
        holder.button.text = item.toString() // 현재 리스트 엘리먼트들은 Char 이므로

        holder.button.setOnClickListener {
            val context: Context = holder.view.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
            // 버튼이 눌릴 때 하는 동작을 여기서 짜는구나.
            // 그럼 A를 눌러서 들어간 창, B를 눌러서 들어간 창 .... Z를 눌러서 들어간 창은 전부 같다. 인텐트에 들어있는 정보에 따라 다른 filtereWords를 사용해서 구성하는 것 일 뿐!
            // holder.button.text는 현재 String이 아니라 CharSequence 타입이라고 한다. 그래서 toString()을 한번 더 써줌

            context.startActivity(intent)
        }
    }

    // Setup custom accessibility delegate to set the text read with an accessibility service
    companion object Accessibility: View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(host: View?, info: AccessibilityNodeInfo?) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.look_up_words)
            val customClick = AccessibilityNodeInfo.AccessibilityAction(AccessibilityNodeInfo.ACTION_CLICK, customString)
            info?.addAction(customClick)
        }
    }
}