package com.kva.aa_petproject.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.text.KButton
import com.kaspersky.kaspresso.screens.KScreen
import com.kva.aa_petproject.R

object NameScreen : KScreen<NameScreen>() {
    override val layoutId: Int? = R.layout.activity_name
    override val viewClass: Class<*>? = com.kva.aa_petproject.NameActivity::class.java


    val nameTV = KEditText { withId(R.id.user_name_tv) }

}