package com.example.sfv.model

import android.provider.ContactsContract.CommonDataKinds.Email
import java.net.IDN

data class User(

    //@DocumentId

    val idn: String = "",
    val email: String = ""
)
