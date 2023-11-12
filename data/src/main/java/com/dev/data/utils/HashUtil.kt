package com.dev.data.utils

import java.security.MessageDigest

object HashUtil {

    fun md5(str: String): String = MessageDigest
        .getInstance("MD5")
        .digest(str.toByteArray(Charsets.UTF_8))
        .toHex()

    private fun ByteArray.toHex() = joinToString(separator = "") {
            byte -> "%02x".format(byte)
    }

}