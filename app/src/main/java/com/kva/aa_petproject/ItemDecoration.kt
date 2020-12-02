package com.kva.aa_petproject

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration (val paddingLeft: Int = 0, val paddingRight: Int = 0, val paddingTop: Int = 0, val paddingBottom: Int = 0) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top += paddingTop
        outRect.bottom += paddingBottom
        outRect.left += paddingLeft
        outRect.right += paddingRight
    }
}