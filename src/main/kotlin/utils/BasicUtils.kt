package me.rerere.utils

fun currentTime() = System.currentTimeMillis()

suspend fun measureCodeTime(block: suspend () -> Unit) : Long {
    val start = currentTime()
    block()
    return currentTime() - start
}