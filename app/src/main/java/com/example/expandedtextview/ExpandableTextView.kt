package com.example.expandedtextview

import android.animation.LayoutTransition
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.text.HtmlCompat


class ExpandableTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {

    private var tvHeader: AppCompatTextView
    private var tvContent: AppCompatTextView
    private var isCollapsed: Boolean = true
    private var rootView: ConstraintLayout
    private var imgArrow: ImageView

    init {
        LayoutInflater.from(context).inflate(R.layout.layout_expandable_textview, this, true)
        orientation = VERTICAL
        rootView = findViewById(R.id.root_container)
        tvHeader = findViewById(R.id.tv_header)
        tvContent = findViewById(R.id.tv_content)
        imgArrow = findViewById(R.id.img_arrow)
        imgArrow.setOnClickListener {
            imgArrow.animate().rotationBy(180f).setDuration(300).start();
            tvContent.visibility = if (isCollapsed) {
                Integer.MAX_VALUE
            } else {
                0
            }
            isCollapsed = !isCollapsed
        }

        applyLayoutTransition()
    }

    private fun applyLayoutTransition() {
        val transition = LayoutTransition()
        transition.setDuration(300)
        transition.enableTransitionType(LayoutTransition.CHANGING)
        rootView.layoutTransition = transition
    }

    fun setHeaderText(content: String) {
        tvHeader.text = content
    }

    fun setSubText(content: String) {
        tvContent.text = HtmlCompat.fromHtml(content, 0)
    }


}