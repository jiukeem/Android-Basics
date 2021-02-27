package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

/**
 * Adapter for the [RecyclerView] in [MainActivity]. Displays [Affirmation] data object.
 */
class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>):
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textview: TextView = view.findViewById(R.id.item_title)
        val imageview: ImageView = view.findViewById(R.id.item_image)
        // R.id.name 은 실제 스트링 값을 가져오는게 아니라 아이디를 Int 로 return 한다.
    }

    /** Create new views (invoked by the layout manager)
    * 새로운 뷰 홀더가 필요할 때 레이아웃 매니저에 의해서 호출됨. 뷰홀더는 리사이클러 뷰의 아이템 한 개를 담을 통이라고 보면된다
    * parent : 뷰홀더가 child로 들어갈 뷰그룹(레이아웃) -> 여기서는 리사이블러뷰겠지
    * viewType : parent 안에 어떤 뷰타입으로 들어갈건지. 나는 한가지 아이템만 넣을거니 별로 신경안써도 된다.
    */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        // 요 부분 이해가 살짝 어렵다. 컨텍스트의 개념이 머리에 잘 안박혀있음. parent는 activity가 아닌 viewGroup 인데 연결된 액티비티가 없다면 컨텍스트가 없을 수도 있는 것 아닌가?
        // 그리고 inflate() 의 파라미터들도 아해가 안감ㅜ LayoutInflater.java 읽어봤는데두..
        // LayoutInflater 는 xml 파일을 view objects 로 변환시켜주는 장치라고 보면 된다.

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * This method is called by the layout manager in order to replace the contents of a list item view.
     * holder: ItemViewHolder 타입으로, onCreateViewHolder 이 return 하는 값
     * position: 변경할 item 의 현재 위치. 이걸 기반으로 dataset의 어떤 오브젝트를 가져올건지 알 수 있다.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textview.text = context.resources.getString(item.stringResourceId)
        holder.imageview.setImageResource(item.imageResourceId)
    }
}

// 어댑터 설정을 끝냈으니, 메인액티비티(리사이클러뷰가 있는 곳)에서 리사이클러뷰에게 이 어댑터를 사용하라고 알려주자.