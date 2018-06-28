package bindings

import kotlin.js.Json

class JsWrapperMap<K, V> {
    val map: dynamic = js("({})")

    operator fun get(key: K): V = map[key]
    operator fun set(key: K, value: V) {
        map[key] = value
    }
}

/**
 * Returns an empty new [JsWrapperMap]
 */
fun <K, V> jsMapOf(): JsWrapperMap<K, V> = JsWrapperMap()

fun <K, V> Map<K, V>.toJsMap(): dynamic {
    val jsMap = jsMapOf<K, V>()
    forEach { jsMap.set(it.key, it.value) }
    return jsMap.map
}

/**
 * Returns an empty new [JsWrapperMap] of type <Any, Any>
 */
fun jsMapOfAny(): JsWrapperMap<Any, Any> = JsWrapperMap()

fun <K, V> jsonToMap(json: Json?): Map<K, V> {
    val map = mutableMapOf<K, V>()
    if (json == null || json == undefined || json === undefined) {
        return map
    }
    for (key in js("Object").keys(json)) {
        map[key] = json[key] as V
    }
    return map
}
