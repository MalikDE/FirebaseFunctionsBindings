package bindings

import kotlin.js.Json

// https://firebase.google.com/docs/reference/functions/functions.Event#params
// https://firebase.google.com/docs/reference/functions/functions.database.DeltaSnapshot

external interface CloudFunction

external interface Event<T> {
    val data: DataSnapshot<T>
    val params: dynamic
}

external interface DataSnapshot<T> {
    val ref: Reference
    val key: String

    fun exists(): Boolean
    fun `val`(): T
    fun toJSON(): Json
    fun numChildren(): Int
    fun forEach(action: (childSnapshot : DataSnapshot<T>) -> Boolean ) //return true to cancel the enumeration
}

fun convertToJsonString(json: dynamic) = js("JSON.stringify(json)")