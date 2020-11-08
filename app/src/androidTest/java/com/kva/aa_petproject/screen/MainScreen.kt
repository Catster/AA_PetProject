package com.kva.aa_petproject.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.text.KButton
import com.kaspersky.kaspresso.screens.KScreen
import com.kva.aa_petproject.R

object MainScreen : KScreen<MainScreen>() {
    override val layoutId: Int? = R.layout.activity_main
    override val viewClass: Class<*>? = com.kva.aa_petproject.MainActivity::class.java


    val loginET = KEditText { withId(R.id.login_et) }
    val passwordET = KEditText { withId(R.id.password_et) }

    val loginBtn = KButton { withId(R.id.login_btn) }

}